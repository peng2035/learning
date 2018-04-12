package com.bobby.peng.learning.java.sync.test;

import com.bobby.peng.learning.java.sync.Sync2;

/**
 * Created by bobby.peng on 2016/10/8.
 */
public class SyncTest {
    private final static int READ_BODY_SIZE = 5120;

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

    public synchronized void methodA() {
        System.out.println("in method A");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("out method A");
    }

    public synchronized void methodB() {
        System.out.println("in method B");
    }

    public static void main(String[] args) throws InterruptedException {
        SyncTest syncTest = new SyncTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                syncTest.methodA();
            }
        }).start();
        Thread.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                syncTest.methodB();
            }
        }).start();

        Thread.sleep(500);
        Sync2 sync2 = new Sync2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sync2.method3(syncTest);
            }
        }).start();

    }
}
