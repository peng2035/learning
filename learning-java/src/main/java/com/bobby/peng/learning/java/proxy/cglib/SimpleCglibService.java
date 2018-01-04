package com.bobby.peng.learning.java.proxy.cglib;

import com.bobby.peng.learning.java.proxy.cglib.guess.GuessedCglibProxy;

/**
 * Created by bobby.peng on 03/01/2018.
 */
public class SimpleCglibService {

    public void method1() {
        System.out.println("SimpleCglibService in method1");
        method2();
    }

    public void method2() {
        System.out.println("SimpleCglibService in method2");
    }

    public static void main(String[] args) {
        GuessedCglibProxy guessedCglibProxy = new GuessedCglibProxy();
        guessedCglibProxy.method1();
    }
}
