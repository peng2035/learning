package com.bobby.peng.learning.java.sync.test;

import java.util.concurrent.*;

/**
 * Created by bobby.peng on 2018/4/18.
 */
public class WaitAndNotifyAllTest {

    public synchronized void get() throws InterruptedException {
        System.out.println("in get method, thread : " + Thread.currentThread());

        this.wait();

        System.out.println("end get method, thread : " + Thread.currentThread());
    }

    public synchronized void set() throws InterruptedException {
        System.out.println("in set method, thread : " + Thread.currentThread());

        this.notifyAll();

        System.out.println("start notify, thread : " + Thread.currentThread());

        TimeUnit.SECONDS.sleep(50);

        System.out.println("end set method, thread : " + Thread.currentThread());
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10,
                15, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10),
                (r, executor) -> {
                    System.out.println("=== reject ===");
                }) {

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("before execute : " + Thread.currentThread());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("after execute : " + Thread.currentThread());
            }
        };

        for (int i = 0; i < 30; i++) {
            pool.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(1000,TimeUnit.SECONDS);
        System.out.println("end");
    }
}
