package com.bobby.peng.learning.java.spring;

import com.bobby.peng.learning.java.exams.ClassB;
import com.bobby.peng.learning.java.spring.test.BeanImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by peng2035 on 16-12-6.
 */
public class LearnIoc {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("appcontext-common.xml");

        System.out.println("Ioc end");
    }

}
