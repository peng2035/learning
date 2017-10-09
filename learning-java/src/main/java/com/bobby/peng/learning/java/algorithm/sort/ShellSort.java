package com.bobby.peng.learning.java.algorithm.sort;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ShellSort {

    public static <T extends Comparable<? super T>> void shellSort(T[] a) {
        int j;

        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for(int i=gap;i<a.length;i++) {
                T temp = a[i];

                for(j=i;j>=gap && temp.compareTo(a[j-gap])<0;j-=gap) {
                    a[j] = a[j-gap];
                }

                a[j] = temp;
            }
        }
    }

}
