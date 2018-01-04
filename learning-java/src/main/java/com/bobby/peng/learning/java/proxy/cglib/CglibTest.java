package com.bobby.peng.learning.java.proxy.cglib;

/**
 * Created by bobby.peng on 2017/8/29.
 */
public class CglibTest {

    public void method1() {
        System.out.println("do method1");
        method2();
    }

    public void method2() {
        System.out.println("do method2");
    }

}
