package com.bobby.peng.learning.java.sync.test;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * Created by bobby.peng on 2016/12/21.
 */
public class FutureTest {

    public static Future<HashMap> get() {
        return Executors.newFixedThreadPool(10).submit(new Callable<HashMap>() {
            @Override
            public HashMap call() throws Exception {
                System.out.println("in call");
                return new HashMap();
            }
        });
    }

    public static void main(String[] args) {
        Future<HashMap> future = get();
        System.out.println("hello");
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(111);

    }

}
