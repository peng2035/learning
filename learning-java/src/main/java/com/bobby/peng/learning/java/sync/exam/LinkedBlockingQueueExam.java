package com.bobby.peng.learning.java.sync.exam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bobby.peng on 2017/3/3.
 */
public class LinkedBlockingQueueExam<E> {

    private Object[] array;

    private int size;

    private int head, tail;

    private int capacity;

    public LinkedBlockingQueueExam(int capacity) {
        this.capacity = capacity;

        array = new Object[capacity];
    }

    public synchronized void put(E value) throws InterruptedException {
        System.out.println("before put : " + value);

        while (isFull()) {
            wait();

            System.out.println("put from wait : " + Thread.currentThread() + " : " + value);
        }

        size++;
        array[tail] = value;

        tail = (tail == capacity - 1 ? 0 : tail + 1);

        System.out.println("put : " + value);
        notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        while (isEmpty()) {
            wait();

            System.out.println("take from wait : " + Thread.currentThread() + " , value : " + array[head]);
        }

        size--;
        E temp = (E)array[head];

        head = (head == capacity - 1 ? 0 : head + 1);

        System.out.println("take : " + temp);
        notifyAll();
        return temp;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueueExam<Integer> queue = new LinkedBlockingQueueExam<>(5);

        ExecutorService putPool = Executors.newFixedThreadPool(10);
        ExecutorService getPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            putPool.submit(() -> {
                try {
                    queue.put(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        Thread.sleep(5000);
        System.out.println("After 5 seconds");
        Thread.sleep(1000);

        for(int i=0;i<15;i++) {
            getPool.submit(() -> {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        Thread.sleep(5000);
        System.out.println("After 5 seconds");
        Thread.sleep(1000);

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            putPool.submit(() -> {
                try {
                    queue.put(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        putPool.shutdown();
        getPool.shutdown();
    }
}
