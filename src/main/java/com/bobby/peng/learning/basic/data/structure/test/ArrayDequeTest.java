package com.bobby.peng.learning.basic.data.structure.test;

import java.util.ArrayDeque;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ArrayDequeTest {

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for(int i=0;i<15;i++) {
            arrayDeque.add(i);
        }

        System.out.println(arrayDeque.contains(5));

    }

}
