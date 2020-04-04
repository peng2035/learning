package com.bobby.peng.learning.java.sync.test;

import org.apache.commons.lang.math.RandomUtils;
import sun.misc.Contended;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bobby.peng on 2018/4/10.
 */
public class VolatileTest {

    @Contended
    private volatile int value = 0;

    @Contended
    private int value2 = 0;

    private int[] value2Arr = new int[10000];

    private Object o = new Object();

    public void test() {
        int random = RandomUtils.nextInt(3);

        if (random != 2) {
            synchronized (o) {
                if (random != 2) {
                    value++;
                    value2++;
                }
            }
        }

        if (value != value2) {
            System.out.println("error : value " + value + " , value2 : " + value2);
        }

//        System.out.println("value : " + value + ", value2 : " + value2);
    }

    public void test2() {
        synchronized (o) {
            value2++;
        }

        if(value2Arr[value2] == 1) {
            System.out.println("error");
        } else{
            value2Arr[value2] = 1;
        }


//        System.out.println(value2);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();

        ExecutorService pool = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 10000; i++) {
            pool.submit(() ->
                    volatileTest.test()
            );
        }

        pool.shutdown();
//        new Thread(() -> {
//            for(int i=0;i<10000;i++) {
//                volatileTest.value++;
//                try {
//                    TimeUnit.NANOSECONDS.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        VolatileTest v2 = volatileTest;
//
//        System.out.println("1st : " + v2.value);
//        TimeUnit.SECONDS.sleep(5);
//        System.out.println("2nd : " + v2.value);
    }

}
