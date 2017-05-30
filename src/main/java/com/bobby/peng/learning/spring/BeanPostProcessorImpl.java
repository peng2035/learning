package com.bobby.peng.learning.spring;

import com.bobby.peng.learning.annoation.MethodAnnotation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by bobby.peng on 2017/2/15.
 */
public class BeanPostProcessorImpl implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println(o.getClass().getName());

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        Class<?> clazz = o.getClass();

        if(clazz.getName().indexOf("BeanImpl") != -1) {
            Method[] methods = clazz.getDeclaredMethods();

            for(Method method : methods) {
                if(null != method.getAnnotation(MethodAnnotation.class)) {
                    System.out.println("find method annotation");
                }
            }
        }

        return o;
    }
}
