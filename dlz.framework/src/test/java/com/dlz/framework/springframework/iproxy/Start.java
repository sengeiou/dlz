package com.dlz.framework.springframework.iproxy;

import org.junit.Before;
import org.junit.Test;

import com.dlz.framework.holder.SpringHolder;

public class Start {
	@Before
	public void setUp() throws Exception {
		SpringHolder.init();
		testService=SpringHolder.getBean("iTestDeal");
		test2Service=SpringHolder.getBean("iTest2Deal");
		test3Service=SpringHolder.getBean("iTestDeal");
	}
	
	ITest2Deal test2Service;
	ITestDeal testService;
	ITestDeal test3Service;

    @Test
    public void test() {
        System.out.println(test2Service.sayHello("1","2"));
        System.out.println(testService.sayHello("-1","-2"));
        System.out.println(test3Service.sayHello("-1","-2"));
        System.out.println(test2Service.sayHello("-1"));
        System.out.println(test2Service.sayHello());
    }
}