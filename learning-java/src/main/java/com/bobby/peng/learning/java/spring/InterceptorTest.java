package com.bobby.peng.learning.java.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by bobby.peng on 2017/12/16.
 */
public class InterceptorTest implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("in invoke");
        Object obj = methodInvocation.proceed();
        System.out.println("out invoke");
        return obj;
    }

}
