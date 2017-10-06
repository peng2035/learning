package com.bobby.peng.learning.sync;

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
}
