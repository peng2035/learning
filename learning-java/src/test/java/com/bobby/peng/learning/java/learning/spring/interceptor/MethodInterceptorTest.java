package com.bobby.peng.learning.java.learning.spring.interceptor;

import com.bobby.peng.learning.java.learning.AbstractTestCase;
import com.bobby.peng.learning.java.spring.aop.AopMethodTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by bobby.peng on 2017/12/16.
 */
public class MethodInterceptorTest extends AbstractTestCase {

    @Autowired
    private AopMethodTest aopMethodTest;

    @org.junit.Test
    public void test() {
        aopMethodTest.testMethod();
    }
}
