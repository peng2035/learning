package com.bobby.peng.learning.java.spring.test;

import com.bobby.peng.learning.java.annotation.MethodAnnotation;

/**
 * Created by bobby.peng on 2017/2/15.
 */
public class BeanImpl {

    @MethodAnnotation
    public void method() {
        System.out.println("BeanImpl method : start");
    }

}
