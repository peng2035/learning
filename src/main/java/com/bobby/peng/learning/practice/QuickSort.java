package com.bobby.peng.learning.practice;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * Created by bobby.peng on 2016/9/28.
 */
public class QuickSort {

    private int[] data;

    public QuickSort(int[] data) {
        this.data = data;

        sort(0, data.length - 1);
    }

    public void sort(int start, int end) {
        if (start == end) {
            return;
        }

        if (start + 1 == end) {
            if (data[start] > data[end]) {
                int temp = data[start];
                data[start] = data[end];
                data[end] = temp;
            }
            return;
        }

        int left = start + 1;
        int right = end;

        int middle = -1;
        while (left < right) {
            while (data[left] <= data[start]) {
                if (left == right) {
                    middle = left;
                    break;
                }
                left++;
            }

            while (data[right] > data[start]) {
                if (left == right) {
                    middle = right - 1;
                    break;
                }
                right--;
            }

            if (left < right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            } else {
                int temp = data[middle];
                data[middle] = data[start];
                data[start] = temp;
            }
        }
        sort(start, middle - 1 < start ? start : middle - 1);
        sort(middle + 1 > end ? end : middle + 1, end);
    }

    public static void main(String[] args) {
        int[] a = {3, 8, 3, 2, 7, 10, 23, 1, 4};
        new QuickSort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
