package com.bobby.peng.learning.java.algorithm.sort;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class MergeSort {

    public static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] temp, int left, int right) {

        if (left > right) {
            int center = (left + right) / 2;

            mergeSort(a, temp, left, center);
            mergeSort(a, temp, center + 1, right);

            merge(a, temp, left, center, right);
        }

    }

    public static <T extends Comparable<? super T>> void merge(T[] a, T[] temp, int left, int center, int right) {

        int rightStart = center + 1;

        for (int i = left, j = rightStart, m = left; i <= center && j <= right; m++) {
            if (i == center) {
                temp[m] = a[j++];
                continue;
            } else if (j == right) {
                temp[m] = a[i++];
                continue;
            }
            if (a[i].compareTo(a[j]) == -1) {
                temp[m] = a[i++];
            } else {
                temp[m] = a[j++];
            }
        }

    }

    public static <T extends Comparable<? super T>> void mergerSort(T[] a) {
        T[] temp = (T[]) new Comparable[a.length];

        mergeSort(a, temp, 0, a.length - 1);
    }



}
