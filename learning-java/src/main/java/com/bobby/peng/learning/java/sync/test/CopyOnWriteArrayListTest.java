package com.bobby.peng.learning.java.sync.test;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by bobby.peng on 2017/3/14.
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList<Integer>();

        for(int i=0;i<100;i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();

        while(iterator.hasNext()) {
            iterator.remove();
        }

        System.out.println(list);
    }

}
