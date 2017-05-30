package com.bobby.peng.learning.exams;

/**
 * Created by bobby.peng on 2017/2/6.
 */
public class StaticDispatch {

    interface Human {}

    interface Live{}

    class Man implements Human,Live{}

    class Woman implements Human, Live {}
//
//    public void sayHello(Man guy) {
//        System.out.println("hello, gentleman!");
//    }

    public void sayHello(Human guy) {
        System.out.println("hello, guy!");
    }

    public void sayHello(Live live) {
        System.out.println("hello live!");
    }

    public void sayHello(Object guy) {
        System.out.println("hello, obj!");
    }
//
//    public void sayHello(Woman guy) {
//        System.out.println("hello, lady!");
//    }

    public static void main(String[] args) {
        StaticDispatch staticDispatch = new StaticDispatch();
        Human man = staticDispatch.new Man();
        Human woman = staticDispatch.new Woman();

        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
    }

}
