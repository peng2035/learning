package com.bobby.peng.learning.java.basic.data.structure.test;

import java.util.Random;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class MergeSort {

    private int[] values;

    public MergeSort(int[] values) {
        this.values = values;
    }

    public void sort() {
        sort(0, values.length - 1);
    }

    private void sort(int start, int end) {
        if (start >= end) {
            return;
        }

        if (end - start == 1) {
            if (values[end] < values[start]) {
                int temp = values[end];
                values[end] = values[start];
                values[start] = temp;
            }
            return;
        }

        int middle = (end + start) >>> 1;
        sort(start, middle);
        sort(middle + 1, end);

        int first = start, second = middle + 1, temp = 0;
        int[] arr = new int[end - start + 1];
        while (first <= middle || second <= end) {
            if (first > middle) {
                arr[temp++] = values[second++];
                continue;
            }

            if (second > end) {
                arr[temp++] = values[first++];
                continue;
            }

            if (values[first] < values[second]) {
                arr[temp++] = values[first++];
            } else {
                arr[temp++] = values[second++];
            }
        }

        for (int i = 0; i <= end - start; i++) {
            values[start + i] = arr[i];
        }
    }

    public static void main(String[] args) {

        int[] values = new int[100];

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            values[i] = random.nextInt(100);
        }

        MergeSort mergeSort = new MergeSort(values);

        mergeSort.sort();

        System.out.println(values);
    }

}
