package com.bobby.peng.learning.java.sync.test;

import org.apache.commons.lang.math.RandomUtils;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by bobby.peng on 2016/12/21.
 */
public class FutureTest {

    private static ExecutorService pool = Executors.newFixedThreadPool(1);


    public static List<Future> get() {
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            Future<String> future = pool.submit(() -> {
                int sleepSeconds = RandomUtils.nextInt(3);
                TimeUnit.DAYS.sleep(1);
                System.out.println("in call " + Thread.currentThread().getName() + " , wait : " + sleepSeconds);
                return Thread.currentThread().getName();
            });
            list.add(future);
        }
        return list;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Future> list = get();
        System.out.println("hello");
        try {
            for (Future future : list) {
                long startTime = System.currentTimeMillis();
                System.out.println("get future method : " + future.get() + "wait time : " + (System.currentTimeMillis() - startTime));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        pool.shutdown();
        pool.awaitTermination(1000,TimeUnit.SECONDS);
    }

}
