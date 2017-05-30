package com.bobby.peng.learning.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ConditionBoundedBuffer<T> {

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition notFull = lock.newCondition();

    private final Condition notEmpty = lock.newCondition();

    private Object[] arr;

    private int size,capacity,head,tail;

    public ConditionBoundedBuffer(int capacity) {
        this.capacity = capacity;
        arr = new Object[capacity];
    }

    public T take() throws InterruptedException {
        try {
            lock.lock();

            while(isEmpty()) {
                notEmpty.await();
            }

            boolean fullFlag = isFull();
            T temp = (T)arr[head];
            head = (head == capacity - 1 ? 0 : head + 1);
            size--;

            if(fullFlag) {
                notFull.signal();
            }

            return temp;
        } finally {
            lock.unlock();
        }
    }

    public void put(T value) throws InterruptedException {
        try {
            lock.lock();

            while(isFull()) {
                notFull.await();
            }

            boolean emptyFlag = isEmpty();
            tail = (tail == capacity - 1 ? 0 : tail + 1);
            arr[tail] = value;
            size++;

            if(emptyFlag) {
                notEmpty.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    private boolean isFull() {
        return capacity == size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

}
