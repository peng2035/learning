package com.bobby.peng.learning.java.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by peng2035 on 2017/4/3.
 */
@Aspect
public class InterceptorTest {

    @Around("execution(* com.bobby.peng.learning.interceptor.test.*.*(..))")
    private void test(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("开始 aop ...");
        pjp.proceed();
        System.out.println("结束 aop ...");
        throw new RuntimeException();
    }

}
