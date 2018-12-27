package com.bobby.peng.learning.java.exams;

import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton newInstance() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        for(int i=0;i<10;i++) {
            pool.execute(() -> {
                System.out.println(111);
                try {
                    Thread.sleep(RandomUtils.nextInt(3000));
                    cyclicBarrier.await();
                    System.out.println(System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
    }
}
