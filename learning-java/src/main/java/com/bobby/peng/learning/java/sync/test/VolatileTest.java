package com.bobby.peng.learning.java.sync.test;

import java.util.concurrent.TimeUnit;

/**
 * Created by bobby.peng on 2018/4/10.
 */
public class VolatileTest {

    private volatile int value = 0;

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();

        new Thread(() -> {
            for(int i=0;i<10000;i++) {
                volatileTest.value++;
                try {
                    TimeUnit.NANOSECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        VolatileTest v2 = volatileTest;

        System.out.println("1st : " + v2.value);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("2nd : " + v2.value);
    }

}
