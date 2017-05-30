package com.bobby.peng.learning.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by peng2035 on 2017/4/24.
 */
public class AutowiredTest {

    @Autowired
    private InnerAutowiredTest innerAutowiredTest;

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-test.xml");

        AutowiredTest autowiredTest = appContext.getBean("autowiredTest",AutowiredTest.class);

        if(autowiredTest == null) {
            System.out.println("autowired test is null");
        }

        if(autowiredTest.innerAutowiredTest == null) {
            System.out.println("inner autowired test is null");
        }
    }

    public InnerAutowiredTest getInnerAutowiredTest() {
        return innerAutowiredTest;
    }

    public void setInnerAutowiredTest(InnerAutowiredTest innerAutowiredTest) {
        this.innerAutowiredTest = innerAutowiredTest;
    }
}
