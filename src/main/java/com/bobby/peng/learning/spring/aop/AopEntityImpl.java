package com.bobby.peng.learning.spring.aop;

import com.bobby.peng.learning.annoation.AopAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bobby.peng on 2017/3/13.
 */
public class AopEntityImpl implements AopEntity{

//    @AopAnnotation
    public void print(String value) {
        System.out.println("in aop entity");
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appcontext-aop.xml");

        AopEntity aopEntityImpl = (AopEntity) applicationContext.getBean("com.bobby.peng.learning.spring.aop.AopEntityImpl");

        aopEntityImpl.print("123");
    }
}
