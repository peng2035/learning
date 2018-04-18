package com.bobby.peng.learning.java.interceptor.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by peng2035 on 2017/4/3.
 */
public class TestAOP {

    public void print() {
        System.out.println("await aop");
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("appcontext-aop.xml");

        TestAOP testAOP = applicationContext.getBean("testAOP",TestAOP.class);

        testAOP.print();


    }

}
