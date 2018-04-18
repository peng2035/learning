package com.bobby.peng.learning.java.sync.test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by bobby.peng on 2018/4/16.
 */
public class ReentrantReadWriteLockTest {

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();

        //todo
        System.out.println("the first time lock read lock start : " + Thread.currentThread());
        test.readLock.lock();
        System.out.println("the first time lock read lock end : " + Thread.currentThread());

        System.out.println("the first time lock write lock start : " + Thread.currentThread());
        test.writeLock.lock();
        System.out.println("the first time lock write lock end : " + Thread.currentThread());

        new Thread(() -> {
            System.out.println("the second time lock read lock start : " + Thread.currentThread());
            test.readLock.lock();
            System.out.println("the second time lock read lock end : " + Thread.currentThread());
        }).start();

        Thread.sleep(1000);
        test.readLock.unlock();
    }

}
