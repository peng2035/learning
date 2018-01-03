package com.bobby.peng.learning.java.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Async;

/**
 * Created by bobby.peng on 02/01/2018.
 */
public class AsyncClass {

    @Async
    public void test() {
        System.out.println(Thread.currentThread() + " in async class test");
    }


    public void testCglib() {
        testCglibInSameClass();
    }

    @Async
    public void testCglibInSameClass() {
        System.out.println(Thread.currentThread() + " in async class testCglibInSameClass");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAsyncConfig.class);

        System.out.println(Thread.currentThread() + " in main method");
        AsyncClass asyncClass = context.getBean(AsyncClass.class);
        asyncClass.test();
        asyncClass.testCglib();
    }

}
