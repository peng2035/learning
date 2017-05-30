package com.bobby.peng.learning.sync.exam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bobby.peng on 2017/3/3.
 */
public class SemaphoreExam {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private final static int LIMIT = 5;

    private int num;

    public void acquire() throws InterruptedException {
        try {
            lock.lock();

            while (isLimit()) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread() + " get semaphore");
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        try {
            lock.lock();

            condition.signal();
            num--;
            System.out.println(Thread.currentThread() + " release semaphore");
        } finally {
            lock.unlock();
        }
    }

    private boolean isLimit() {
        return LIMIT == num;
    }

    public static void main(String[] args) {
        SemaphoreExam semaphoreExam = new SemaphoreExam();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for(int i=0;i<10;i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphoreExam.acquire();
                        Thread.sleep(1000);
                        semaphoreExam.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        pool.shutdown();
    }
}
