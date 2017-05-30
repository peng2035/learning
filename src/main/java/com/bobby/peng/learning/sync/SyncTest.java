package com.bobby.peng.learning.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bobby.peng on 2016/10/8.
 */
public class SyncTest {

    public void test() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("notify all :" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                System.out.println("notify all after sleep:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void notified() {
        synchronized (this) {
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        SyncTest syncTest = new SyncTest();

        for(int i=0;i<1000;i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    syncTest.test();
                }
            });
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        syncTest.notified();
    }
    
}
