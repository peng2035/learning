package com.bobby.peng.learning.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by peng2035 on 2017/6/28.
 */
public class ConcurrentHashMapTest {

    private volatile String value;

    public ConcurrentHashMapTest(String value) {
        this.value = value;
    }

    private String get() {
        System.out.println("get value : " + this.value);
        return this.value;
    }

    private synchronized void putValue(String value) throws InterruptedException {
        System.out.println("put value");

        Thread.sleep(5000l);

        this.value = value;
        System.out.println("put value end : " + this.value);

    }

    public static void main(String[] args) throws InterruptedException {
        String value = "1";
        ConcurrentHashMapTest concurrentHashMapTest = new ConcurrentHashMapTest(value);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    concurrentHashMapTest.putValue("123");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(500l);

        new Thread(() -> {
            concurrentHashMapTest.get();
        }).start();

//        ExecutorService setPool = Executors.newFixedThreadPool(5);
//        for(int i = 0;i<5;i++) {
//            value  = value + "1";
//            final String temp = value;
//            setPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        concurrentHashMapTest.putValue(temp);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//
//        try {
//            Thread.sleep(500l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        ExecutorService readPool = Executors.newFixedThreadPool(5);
//        for(int i = 0;i < 5 ;i++) {
//            readPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    concurrentHashMapTest.get();
//                }
//            });
//
//            try {
//                Thread.sleep(10l);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        readPool.shutdown();
//        setPool.shutdown();
    }
}
