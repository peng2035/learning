package com.bobby.peng.learning.java.sync.test;

import java.util.concurrent.Callable;

/**
 * Created by bobby.peng on 2018/4/24.
 */
public class CallableTest implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("in call method");
        return null;
    }

    public static void main(String[] args) {

    }
}
