package com.bobby.peng.learning.java.algorithm.sort;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class InsertionSort {

    //插入排序

    public <T extends Comparable<? super T>> void insertionSort(T[] a) {
        for(int i = 0;i < a.length; i++) {
            T temp = a[i];
            for(int j = i - 1;j >= 0; j--) {
                if(temp.compareTo(a[j]) == -1 || temp.compareTo(a[j]) == 0) {
                    a[j] = a[j-1];
                    a[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }



}
