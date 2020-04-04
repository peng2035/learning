package com.bobby.peng.learning.java.exams;

/**
 * Created by bobby.peng on 2018/11/19.
 */
public class Singleton3 {

    private Singleton3() {}

    private static class Singleton3Holder {
        static final Singleton3 INSTANCE = new Singleton3();
    }



}
