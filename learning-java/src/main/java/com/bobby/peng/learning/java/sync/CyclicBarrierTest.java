package com.bobby.peng.learning.java.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bobby.peng on 2016/12/21.
 */
public class CyclicBarrierTest {

    private int value;

    public CyclicBarrierTest(int value) {
        this.value = value;
    }

    public synchronized void await(int val) throws InterruptedException {
        if(--value > 0) {
            this.wait();
            System.out.println("in wait : " + val);
        } else {
            this.notifyAll();
            System.out.println("in notify : " + val);
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest(8);
//
//        ExecutorService servicePool = Executors.newFixedThreadPool(10);
//        for(int i=0;i<10;i++) {
//            int finalI = i;
//            servicePool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        cyclicBarrierTest.await(finalI);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//
//        servicePool.shutdown();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for(int i=0;i<10;i++) {
            int finalI = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                    try {
                        cyclicBarrier.await();
                        System.out.println(finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("all over");
    }

}
