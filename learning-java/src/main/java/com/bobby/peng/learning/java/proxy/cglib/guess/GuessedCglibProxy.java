package com.bobby.peng.learning.java.proxy.cglib.guess;

import com.bobby.peng.learning.java.proxy.cglib.SimpleCglibService;

/**
 * Created by bobby.peng on 03/01/2018.
 */
//猜想的cglib生成类简易写法
public class GuessedCglibProxy extends SimpleCglibService {

    @Override
    public void method1() {
        System.out.println("GuessedCglibProxy in method1");
        super.method1();
    }

    @Override
    public void method2() {
        System.out.println("GuessedCglibProxy in method2");
        super.method2();
    }
}
