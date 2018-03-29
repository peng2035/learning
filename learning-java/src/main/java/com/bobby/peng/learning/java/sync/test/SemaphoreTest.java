package com.bobby.peng.learning.java.sync.test;

import java.util.concurrent.Semaphore;

/**
 * Created by bobby.peng on 26/03/2018.
 */
public class SemaphoreTest {

    private static Semaphore semaphore = new Semaphore(5);

    public void acquire() throws InterruptedException {
        semaphore.acquire();

    }

    public void releaseAcquire() {
        semaphore.release();
    }

    public static void main(String[] args) throws InterruptedException {
        SemaphoreTest semaphoreTest = new SemaphoreTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    semaphoreTest.releaseAcquire();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            semaphoreTest.acquire();
            System.out.println(i);
        }


    }
}
