package com.bobby.peng.learning.java.sync.CustomerAndProduct;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by bobby.peng on 2017/2/27.
 */
public class ProductTest<T> {

    private final Queue<T> queue;

    public ProductTest(Queue<T> queue) {
        this.queue = queue;
    }

    public synchronized void put(T value) {
        queue.add(value);
        System.out.println("product put : " + value);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedBlockingQueue<>();

        ProductTest<Integer> productTest = new ProductTest<>(queue);

        CustomerTest<Integer> customerTest = new CustomerTest<>(queue);

        ExecutorService productPool = Executors.newFixedThreadPool(10);
        ExecutorService customerPool = Executors.newFixedThreadPool(3);

        for(int i=0;i<100;i++) {
            customerPool.execute(() -> {
                customerTest.get();
            });
        }

        for(int i=0;i<10;i++) {
            int finalI = i;
            productPool.execute(() -> {
                productTest.put(finalI);
            });
        }



        customerPool.shutdown();
        productPool.shutdown();
    }
}
