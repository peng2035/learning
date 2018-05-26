package com.bobby.peng.learning.java.exams;

/**
 * Created by bobby.peng on 2018/4/18.
 */
public class Singleton2 {

    private static class SingletonHolder {
        private final static Singleton2 SINGLETON_2 = new Singleton2();

        private SingletonHolder() {}
    }

    private Singleton2() {}

    public static Singleton2 newInstance() {
        return SingletonHolder.SINGLETON_2;
    }
}
