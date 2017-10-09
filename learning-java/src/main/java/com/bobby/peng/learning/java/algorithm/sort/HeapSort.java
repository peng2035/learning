package com.bobby.peng.learning.java.algorithm.sort;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class HeapSort<T extends Comparable<? super T>> {

    private int capacity;

    private T[] array;

    public HeapSort(int capacity, T[] array) {
        for (int i = (capacity) / 2 - 1; i >= 0; i--) {
            percDown(i);
        }

        for (int i = 0; i < capacity; i++) {
            T t = deleteMin();
            array[--capacity] = t;
        }
    }


    public T insert(T t) {
        capacity++;

        for (int i = capacity - 1; (i - 1) >= 0; ) {
            int j = (i - 1) / 2;
            if (array[i].compareTo(array[j]) == -1) {
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i = j;
            } else {
                break;
            }
        }

        return t;
    }

    public T deleteMin() {
        T result = array[0];
        array[0] = array[--capacity];

        for (int i = 0; 2 * i + 1 < capacity; ) {

            int j = 2 * i + 1;
            j = (array[j].compareTo(array[j + 1]) == -1 ? j : j + 1);

            if (array[i].compareTo(array[j]) == 1) {
                T temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i = j;
            } else {
                break;
            }
        }

        return result;
    }

    public void percDown(int i) {
        for (int j = i; j * 2 + 1 <= array.length; ) {
            int child = j * 2 + 1;
            if (array.length >= child + 1) {
                child = (array[child].compareTo(array[child + 1]) == -1 ? child : child + 1);
            }

            if (array[j].compareTo(array[child]) != -1) {
                j = child;
            }
        }
    }
}
