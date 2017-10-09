package com.bobby.peng.learning.java.sync.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class LockTest {

    int value = 0;

    Lock lock = new ReentrantLock();
    public void add() {
        try {
            lock.lock();
            value++;
            System.out.println(value);
        } finally {
            lock.unlock();
        }
    }

    public synchronized void add2() {
        value++;
        System.out.println(value);
    }

    public static void main(String[] args) throws InterruptedException {

        LockTest lockTest = new LockTest();

        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        CountDownLatch countDownLatch = new CountDownLatch(100000);

        for(int i=0;i<100000;i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    lockTest.add();
                }
            });
            countDownLatch.countDown();
        }

        executorService.shutdown();

        countDownLatch.await();

//        System.out.println(lockTest.value);
    }

}
