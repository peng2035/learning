package com.bobby.peng.learning.java.structure;

/**
 *
 * 最小堆
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    public static final int DEFAULT_CAPACITY = 10;

    private int currentSize;

    private Comparable[] array;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        if (capacity < 1) {
            throw new RuntimeException("heap capacity must be larger than zero");
        }
        this.currentSize = 0;
        array = new Comparable[capacity + 1];
    }

    public BinaryHeap(T[] array) {
        this.array = array;
        this.currentSize = array.length;
    }

    public void insert(T t) {
        if (isFull()) {
            throw new RuntimeException("heap is full");
        }

        array[currentSize++] = t;

        for(int hole=currentSize;hole>1;hole/=2) {
            array[hole] = array[hole/2];
            array[hole/2] = t;
        }
    }

    public T findMin() {
        if (array[1] == null) {
            return null;
        }
        return (T) array[1];
    }

    public T deleteMin() {
        if (currentSize == 0) {
            throw new RuntimeException("heap is empty");
        }

        currentSize--;
        T t = (T) array[1];
        array[1] = null;
        percolateDown(1);
        return t;
    }

    public boolean isEmpty() {
        if (currentSize == 0) {
            return true;
        }
        return false;
    }

    public void makeEmpty() {
        this.currentSize = 0;
        this.array = null;
    }

    private void percolateDown(int hole) {

        int child = hole;

        Comparable t = array[hole];
        for(;hole * 2 <= currentSize;hole = child) {
            child = hole * 2;
            if(child < currentSize) {
                child = (array[child].compareTo(array[child+1])>0 ? child : child + 1);
            }

            if(array[hole].compareTo(array[child]) > 0) {
                array[hole] = child;
            } else {
                break;
            }
        }

        array[child] = t;
    }

    private void buildHeap() {

    }

    private void enlargeArray(int newSize) {

    }

    private boolean isFull() {
        if (currentSize >= array.length) {
            return true;
        }
        return false;
    }
}
