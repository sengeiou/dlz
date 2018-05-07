package com.dlz.framework.springframework.iproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

import com.dlz.framework.holder.SpringHolder;
import com.dlz.framework.springframework.iproxy.anno.AnnoInterfaceDeal;

/**
 * 接口代理创建工厂
 * @author dingkui
 *
 * @param <T>
 */
class InterfaceProxyFactory<T> implements FactoryBean<T> {
    private Class<T> clas;
    public Class<T> getInterfaceClass() {
        return clas;
    }
    public void setInterfaceClass(Class<T> interfaceClass) {
        this.clas = interfaceClass;
    }
    
	@Override
	public T getObject() throws Exception {
		return (T) new InterfaceProxy().bind(clas);
	}

    @Override
    public Class<?> getObjectType() {
        return clas;
    }

    @Override
    public boolean isSingleton() {
        // 单例模式
        return true;
    }
    
    private static Map<String,AInterfaceProxyHandler> cachedHandlers = new HashMap<>();
    /**
     * 接口代理实现
     * @author dingkui
     *
     */
    public class InterfaceProxy implements InvocationHandler{
        private Class<?> cls;
        private String handlerName;
        
        private AInterfaceProxyHandler getHandler(){
        	AInterfaceProxyHandler proxyHandler = cachedHandlers.get(handlerName);
        	if(proxyHandler==null){
        		handlerName=cls.getAnnotation(AnnoInterfaceDeal.class).value();
        		proxyHandler=SpringHolder.getBean(handlerName);
        		cachedHandlers.put(handlerName, proxyHandler);
        	}
        	return proxyHandler;
        }

        @SuppressWarnings("unchecked")
    	public T bind(Class<T> cls) {
            this.cls = cls;
            return (T)Proxy.newProxyInstance(cls.getClassLoader(), new Class[] {cls}, this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return getHandler().done(cls,method, args);
        }
    }
}