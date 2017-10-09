package com.bobby.peng.learning.java.practice;

/**
 * Created by bobby.peng on 2016/9/27.
 */
public class HeapSort {

    private int[] data;

    private int currentIndex;

    private HeapSort(int[] data) {
        this.data = data;
        this.currentIndex = data.length - 1;

        for (int i = (currentIndex - 1) / 2; i >= 0; i--) {
            down(i);
        }
    }

    public int[] sort() {
        while (currentIndex > 0) {
            int temp = data[0];
            data[0] = data[currentIndex];
            down(0);

            data[currentIndex] = temp;
            currentIndex--;
        }

        return data;
    }

    private void down(int index) {
        int leftTreeIndex = 2 * index + 1;

        if (leftTreeIndex > currentIndex) {
            return;
        } else if (leftTreeIndex == currentIndex) {
            if (data[leftTreeIndex] < data[index]) {
                int temp = data[index];
                data[index] = data[leftTreeIndex];
                data[leftTreeIndex] = temp;
            }
        } else {
            int tempIndex = data[leftTreeIndex] > data[leftTreeIndex + 1] ? leftTreeIndex + 1 : leftTreeIndex;
            if (data[index] > data[tempIndex]) {
                int temp = data[index];
                data[index] = data[tempIndex];
                data[tempIndex] = temp;
            }
            down(tempIndex);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 8, 3, 2, 7, 10, 23, 1, 4};
        HeapSort heapSort = new HeapSort(a);
        heapSort.sort();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
