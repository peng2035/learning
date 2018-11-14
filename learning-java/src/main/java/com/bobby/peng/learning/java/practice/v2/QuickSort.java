package com.bobby.peng.learning.java.practice.v2;

/**
 * Created by bobby.peng on 2018/6/20.
 */
public class QuickSort {

    public static void sort(int[] arr, int start, int end) {
        int flag = arr[start];
        if (start >= end) return;
        int l = start + 1, h = end;
        while (l < h) {
            while (l < h && flag >= arr[h]) {
                h--;
            }
            arr[l] = arr[h];

            while (l < h && flag <= arr[l]) {
                l++;
            }
            arr[h] = arr[l];

        }
        arr[l] = flag;

        sort(arr, start, l - 1);
        sort(arr, l + 1, end);

    }

    public static void main(String[] args) {

    }

}
