package com.bobby.peng.learning.java.sync.test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ConcurrentLinkedQueueTest {

    private ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

    public void put(int value) {
        System.out.println(Thread.currentThread() + " in put method");
        queue.add(value);
    }

    public Integer get() {
        return queue.poll();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService putPool = Executors.newFixedThreadPool(10);

        ExecutorService getPool = Executors.newFixedThreadPool(10);

        ConcurrentLinkedQueueTest concurrentLinkedQueueTest = new ConcurrentLinkedQueueTest();

        for(int i=0;i<100;i++) {
            getPool.submit(() -> {
                System.out.println(Thread.currentThread() + " : " + concurrentLinkedQueueTest.get());
            });
        }

        Thread.sleep(1000);

        for(int i=0;i<100;i++) {
            int finalI = i;
            putPool.submit(() -> {
                concurrentLinkedQueueTest.put(finalI);
            });
        }

        getPool.shutdown();
        putPool.shutdown();
    }

}
