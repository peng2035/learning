package com.bobby.peng.learning.java.sync;

/**
 * Created by bobby.peng on 28/01/2018.
 */
public class Sync2 {

    public void method3(SyncTest syncTest) {
        synchronized (syncTest) {
            System.out.println("in method3");
        }
    }

}
