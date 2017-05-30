package com.bobby.peng.learning.algorithm.sort;

import java.util.Arrays;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class QuickSort {

    public static <T extends Comparable<? super T>> T medianOfThreePartitioning(T[] a) {
        T[] temp = (T[]) new Comparable[3];

        temp[0] = a[0];
        temp[1] = a[a.length / 2];
        temp[2] = a[a.length - 1];

        Arrays.sort(temp);

        return temp[1];
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] a, int index) {
        T temp = a[index];
        a[index] = a[a.length - 1];
        a[a.length - 1] = temp;

        for (int i = 0, j = a.length - 2; i < j; ) {
            while (a[i++].compareTo(a[a.length - 1]) < 0) {
                if(i>=j) {
                    temp = a[j];
                    a[j] = a[a.length - 1];
                    a[a.length - 1] = temp;

                    return;
                }
            }

            while (a[j].compareTo(a[a.length - 1]) >= 0) {
                if(i>=j) {
                    temp = a[i];
                    a[i] = a[a.length - 1];
                    a[a.length - 1] = temp;

                    return;
                } else {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    break;
                }
            }
        }
    }

}
