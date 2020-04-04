package com.bobby.peng.learning.java.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2018/9/3.
 */
public class GCFromSpace {
    //-verbose:gc -Xms20M -Xmx20M -Xmn12M -XX:+PrintGCDetails -XX:SurvivorRatio=1 -XX:+PrintHeapAtGC


    public static int _500K = 1024 * 512;

    public Object instance = null;

    public static void main(String[] args) throws InterruptedException {
        List<GCFromSpace> gcFromSpaces = new ArrayList<>();
        System.gc();
        for (int i = 0; i < 10; i++) {
            System.out.println("insert times : " + i + " start");
//            if(i==3) Thread.sleep(30000);
//            else Thread.sleep(10000);
            if (i >= 4) {
                gcFromSpaces.add(new FiveHundredKB());
                continue;
            } else {
                gcFromSpaces.add(new MB());
            }

//            System.gc();

//            if(i==3) Thread.sleep(30000);
            System.out.println("insert times : " + i + " end");
        }

//        System.out.println("======================begin first gc =============================");
//        System.gc();
//        System.out.println("====================== first gc end  =============================");
//
//        for(int i=3;i<5;i++) {
//            gcFromSpaces.set(i,null);
//        }
//
//        System.out.println("======================begin second gc =============================");
//        System.gc();
//        System.out.println("====================== second gc end  =============================");
//
//        for(int i=6;i<8;i++) {
//            gcFromSpaces.add(new GCFromSpace());
//        }
//        System.out.println("======================begin third gc =============================");
//        System.gc();
//        System.out.println("====================== third gc end  =============================");

    }

    static class MB extends GCFromSpace {
        private byte[] value = new byte[_500K * 2];

    }

    static class FiveHundredKB extends GCFromSpace {
        private byte[] value = new byte[_500K];
    }
}
