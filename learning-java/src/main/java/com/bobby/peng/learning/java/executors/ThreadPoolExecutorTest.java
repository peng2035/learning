package com.bobby.peng.learning.java.executors;

import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by bobby.peng on 2016/11/10.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws Exception {
        System.out.println(System.currentTimeMillis());
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++) {
            exec.execute(new Task());
        }
        exec.shutdownNow();
//        exec.awaitTermination(1,TimeUnit.DAYS);
        System.out.println("mission completed");
    }

    private static class Task implements Runnable {
        public void run() {
            System.out.println("start running");
            try {
                TimeUnit.SECONDS.sleep(RandomUtils.nextInt(10));
                System.out.println(Thread.currentThread() + " : " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                System.out.println("Interrupted sleep");
                System.out.println(System.currentTimeMillis());
            }
            System.out.println("finish running");
        }
    }

//    public static void main(String[] args) {
//
//        int count = 10;
//
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
//        final List<Integer> l = new ArrayList<>();
//        final Random random = new Random();
//        for(int i=0;i<count;i++) {
//            threadPoolExecutor.execute(new Runnable() {
//                @Override
//                public void run() {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    l.add(random.nextInt());
//                }
//            });
//        }
//        threadPoolExecutor.shutdown();
//
//        try {
//            threadPoolExecutor.awaitTermination(1,TimeUnit.DAYS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(l.size());
//    }

}
