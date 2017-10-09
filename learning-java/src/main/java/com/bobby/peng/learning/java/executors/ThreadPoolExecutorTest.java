package com.bobby.peng.learning.java.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by bobby.peng on 2016/11/10.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        int count = 10;

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
        final List<Integer> l = new ArrayList<>();
        final Random random = new Random();
        for(int i=0;i<count;i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    l.add(random.nextInt());
                }
            });
        }
        threadPoolExecutor.shutdown();

        try {
            threadPoolExecutor.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(l.size());
    }

}
