package com.bobby.peng.learning.java.sync.CustomerAndProduct;

import java.util.Queue;

/**
 * Created by bobby.peng on 2017/2/27.
 */
public class CustomerTest<T> {

    private final Queue<T> queue;

    public CustomerTest(Queue<T> queue) {
        this.queue = queue;
    }

    public synchronized T get() {
        T value = queue.poll();
        System.out.println("customer get : " + (value == null ? null : value.toString()));
        return value;
    }
}
