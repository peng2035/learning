package com.bobby.peng.learning.java.sync.exam;

import org.apache.commons.lang.math.RandomUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bobby.peng on 2018/7/3.
 */
public class ReadWriteLockExam {


    private AtomicInteger readCount = new AtomicInteger();

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public int value = 0;

    public void read() throws InterruptedException {
        if (readCount.get() == 0) {
            lock.lock();
            try {
                while (readCount.get() != 0) {
                    condition.await();
                }
                readCount.incrementAndGet();
            } finally {
                lock.unlock();
            }
        } else {
            readCount.incrementAndGet();
        }

        // do read

        if (readCount.decrementAndGet() == 0) {
            lock.lock();
            try {
                if (readCount.get() == 0) {
                    condition.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void write() throws InterruptedException {
        if (readCount.get() == 0) {
            lock.lock();
            try {
                while (readCount.get() != 0) {
                    condition.await();
                }
                // do write

                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(100);

        ReadWriteLockExam readWriteLockExam = new ReadWriteLockExam();

        for (int i = 0; i < 1000; i++) {
            pool.execute(() -> {
                try {
                    readWriteLockExam.write();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0; i < 1000; i++) {
            pool.execute(() -> {
                try {
                    readWriteLockExam.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();
        if (pool.isTerminated()) {
            System.out.println(readWriteLockExam.value);
        }


    }
}
