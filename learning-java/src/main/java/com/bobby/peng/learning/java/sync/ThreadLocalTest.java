package com.bobby.peng.learning.java.sync;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by peng2035 on 2017/4/3.
 */
public class ThreadLocalTest{

    public static void main(String[] args) {

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        ExecutorService pool = Executors.newFixedThreadPool(5);

        Map<Thread,Integer> map = new ConcurrentHashMap<>();

        for(int i=0;i<100;i++) {
            pool.execute(() -> {
                if(threadLocal.get() == null) {
                    threadLocal.set(1);
                } else {
                    threadLocal.set(threadLocal.get() + 1);
                }

                map.put(Thread.currentThread(),threadLocal.get());
            });
        }

        pool.shutdown();

        for(Map.Entry<Thread,Integer> entry : map.entrySet()) {
            System.out.println("Map key : " + entry.getKey() + ", value : " + entry.getValue());
        }
    }

}
