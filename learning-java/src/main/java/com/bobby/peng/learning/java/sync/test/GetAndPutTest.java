package com.bobby.peng.learning.java.sync.test;

/**
 * Created by bobby.peng on 2016/12/15.
 */
public class GetAndPutTest {

    volatile int i = 0;

    public void get() {
        System.out.println("do get method: i=" + i);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("do get method end");
    }

    public synchronized void put() {
        System.out.println("do put method start : i=" + i);
        i++;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("do put method end");
    }

    public static void main(String[] args) {
        GetAndPutTest getAndPutTest = new GetAndPutTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                getAndPutTest.put();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                getAndPutTest.get();
            }
        }).start();
    }
}
