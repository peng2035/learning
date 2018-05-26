package com.bobby.peng.learning.java.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by bobby.peng on 27/01/2018.
 */
public class GuavaCache {

    private Cache<String, Integer> cache = CacheBuilder.newBuilder().
            expireAfterWrite(2, TimeUnit.SECONDS).build();

    private int value = 1;

    public int getCache() {
        try {
            return cache.get("key", new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println("in call");
                    return value++;
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GuavaCache guavaCache = new GuavaCache();

        while(true) {
            System.out.println(guavaCache.getCache());
            Thread.sleep(500);
        }
    }
}
