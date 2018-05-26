package com.bobby.peng.learning.java.sync.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bobby.peng on 2018/4/7.
 */
public class ReentrantLockTest {

    private Lock lock = new ReentrantLock();

    public void test() {
        System.out.println(Thread.currentThread() + " try lock");
        lock.lock();
        try {
            System.out.println(Thread.currentThread() + " in method");
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                reentrantLockTest.test();
            }
        };

        new Thread(runnable).start();
        TimeUnit.MINUTES.sleep(1);

        new Thread(runnable).start();
        TimeUnit.MINUTES.sleep(1);

        new Thread(runnable).start();
    }

}
