package com.bobby.peng.learning.java.sync.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by bobby.peng on 26/03/2018.
 */
public class SemaphoreTest {

    private static Semaphore semaphore = new Semaphore(1);

    public void acquire() throws InterruptedException {
        semaphore.acquire();

    }

    public void releaseAcquire() {
        semaphore.release();
    }

    public static void main(String[] args) throws InterruptedException {
        SemaphoreTest semaphoreTest = new SemaphoreTest();

        for (int i = 0; i < 2; i++) {

            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(finalI);
                        semaphoreTest.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            TimeUnit.SECONDS.sleep(5);
        }


    }
}
