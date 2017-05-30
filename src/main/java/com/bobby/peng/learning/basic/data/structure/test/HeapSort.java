package com.bobby.peng.learning.basic.data.structure.test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by bobby.peng on 2017/2/28.
 */
public class HeapSort {

    private int capacity;

    private int[] value;

    private int size;

    public HeapSort(int capacity) {
        this.capacity = capacity;
        this.value = new int[capacity];
    }

    public HeapSort(int[] value) {
        this.capacity = value.length;
        this.size = value.length;
        this.value = value;
        sort();
    }

    public void put(int value) {
        size++;
        if (capacity < size) {
            resize();
        }
        this.value[size - 1] = value;

        up(size - 1);
    }

    public int get() {
        if(size == 0) throw new RuntimeException("empty");
        size--;
        int result = value[0];
        value[0] = value[size];
        value[size] = 0;

        down(0);

        return result;
    }

    public boolean checkHeap(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        boolean leftFlag = true,rightFlag = true;
        if(left < size) {
            if(value[index] <= value[left]) {
                leftFlag = checkHeap(left);
            } else {
                return false;
            }
        }
        if(right < size) {
            if (value[index] <= value[right]) {
                rightFlag = checkHeap(right);
            } else {
                return false;
            }
        }
        return leftFlag && rightFlag;
    }

    private void resize() {
        capacity = capacity + (capacity >>> 1);

        value = Arrays.copyOf(value, capacity);
    }

    private void sort() {
        int index = capacity >>> 1 - 1;
        for (int i = index; i >= 0; i++) {
            down(i);
        }
    }

    private void up(int i) {
        if (i == 0) return;
        int num = value[i];
        int parent = i;
        while (true) {
            int child = ((parent + 1) >>> 1) - 1;
            if (value[child] <= num) {
                break;
            } else {
                value[parent] = value[child];
            }
            parent = child;
            if (parent <= 0) break;
        }
        value[parent] = num;
    }

    private void down(int i) {
        int temp = value[i];
        int parent = i;
        int child = 0;
        while ((child = (parent << 1) + 1) < size) {
            if (child + 1 < size) {
                child = value[child] < value[child + 1] ? child : child + 1;
            }
            if (temp > value[child]) {
                value[parent] = value[child];
                parent = child;
            } else {
                break;
            }
        }
        value[parent] = temp;
    }

    public static void main(String[] args) {
        Random random = new Random();

        HeapSort heapSort = new HeapSort(10);
        System.out.println("input value : ");

        for (int i = 0; i < 100; i++) {
            int value = random.nextInt(30) + 1;
            System.out.print(value + ",");
            heapSort.put(value);
        }

        System.out.println();
        System.out.println("check result : " + heapSort.checkHeap(0));

        int temp = 0;
        System.out.println();
        System.out.println("out put value : ");
        for (int i = 0; i < 100; i++) {
            int value = heapSort.get();
            if (temp > value) {
                System.out.println("error");
            }
            temp = value;
            System.out.print(value + ",");
        }
    }
}
