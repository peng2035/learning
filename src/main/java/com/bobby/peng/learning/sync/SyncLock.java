package com.bobby.peng.learning.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by bobby.peng on 2016/11/11.
 */
public class SyncLock implements Lock {
    private boolean flag = true;

    @Override
    public void lock() {
        try {
            synchronized (this) {
                while (flag == false) {
                    this.wait();
                }
                flag = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        synchronized (this) {
            this.flag = true;
            this.notifyAll();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public static void main(String[] args) {
        Lock lock = new SyncLock();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1000);
        CountDownLatch countDownLatch = new CountDownLatch(1000);

        List<String> array = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
//                        System.out.println(Thread.currentThread().getName());
//                        System.out.println("hello world : " + Thread.currentThread().getName());
                        array.add(Thread.currentThread().getName());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        array.add("hello world : " + Thread.currentThread().getName());
                    } finally {
                        lock.unlock();
                        countDownLatch.countDown();
                    }
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fixedThreadPool.shutdown();
        for (int i = 0; i < array.size(); i++) {
            String value = array.get(i);
            i++;
            if (array.get(i).indexOf(value) == -1) {
                System.out.println("error : " + array.get(i));
            }
        }


    }
}
