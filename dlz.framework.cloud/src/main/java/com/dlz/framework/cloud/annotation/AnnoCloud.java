package com.dlz.framework.cloud.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;  
/** 
 * spring cloud访问接口注解
 * Author: dk 2017-06-16
 * Since: 
 */  
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AnnoCloud {
	String value() default ""; 
}