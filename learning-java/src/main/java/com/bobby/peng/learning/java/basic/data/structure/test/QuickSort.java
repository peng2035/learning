package com.bobby.peng.learning.java.basic.data.structure.test;

import java.util.Random;

/**
 * Created by bobby.peng on 2017/2/28.
 */
public class QuickSort {

    public int[] value;

    public QuickSort(int[] value) {
        this.value = value;
    }

    public void sort() {
        sort(0, value.length - 1);
    }

    private void sort(int start, int end) {
        if (start >= end) {
            return;
        }

        if(end - start == 1) {
            if(value[end] < value[start]) {
                int m = value[end];
                value[end] = value[start];
                value[start] = m;
            }
            return;
        }

        int s = start, e = end - 1, split = value[end], middle = -1;
        while (s < e) {
            while(s < e && value[s] < split) {
                s++;
            }
            while(s < e && value[e] >= split) {
                e--;
            }
            if(s == e) {
                if(value[e] < split) {
                    middle = e+1;
                } else {
                    middle = s;
                }
                int m = value[middle];
                value[middle] = value[end];
                value[end] = m;
                break;
            } else {
                int m = value[s];
                value[s] = value[e];
                value[e] = m;
            }
        }
        String log = String.format("start : %d, end : %d , middle : %d" ,start,end,middle);
        System.out.println(log);
        sort(start,middle - 1);
        sort(middle + 1, end);
    }

    public static void main(String[] args) {
        int[] values = new int[100];

        Random random = new Random();
        for(int i=0;i<100;i++) {
            values[i] = random.nextInt(100);
        }

        QuickSort quickSort = new QuickSort(values);

        quickSort.sort();
        System.out.println(values);
    }
}
