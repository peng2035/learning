package com.bobby.peng.learning.java.functional;

/**
 * Created by bobby.peng on 04/01/2018.
 */
public class FunctionalInterfaceWithExceptionImpl {

    public static void main(String[] args) {
        FunctionalInterfaceWithException target = i -> {
            throw new RuntimeException();
        };
        try {
            target.apply(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
