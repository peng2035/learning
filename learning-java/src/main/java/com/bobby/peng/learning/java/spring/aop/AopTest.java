package com.bobby.peng.learning.java.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by bobby.peng on 2017/3/13.
 */
@Aspect
public class AopTest {

    @Pointcut("@annotation(com.bobby.peng.learning.java.annoation.AopAnnotation)")
    private void aopService() {
        System.out.println("in aop service");
    }

    @Around("aopService()")
    public void interceptor(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("start interceptor");
        pjp.proceed();
        pjp.getArgs();
        pjp.getSignature();
        pjp.getTarget();
        System.out.println("end interceptor");
    }

}
