package com.bobby.peng.learning.spring;

import com.bobby.peng.learning.exams.ClassB;
import com.bobby.peng.learning.spring.test.BeanImpl;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by peng2035 on 16-12-6.
 */
public class LearnIoc {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("appcontext-common.xml");

        System.out.println("Ioc end");
    }

}
