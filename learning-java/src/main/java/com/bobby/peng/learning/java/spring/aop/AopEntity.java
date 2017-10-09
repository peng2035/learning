package com.bobby.peng.learning.java.spring.aop;

import com.bobby.peng.learning.java.annoation.AopAnnotation;

/**
 * Created by peng2035 on 2017/4/7.
 */
public interface AopEntity {

    @AopAnnotation
    void print(String value);

}
