package com.bobby.peng.learning.java.algorithm;

/**
 * Created by bobby.peng on 2016/8/17.
 */
public class InsertionSort {

    public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T temp = array[i];
            int max = i-1;
            int min = 0;
            int position = -1;
            while (min > max) {
                position = (min + max)/2;

                if(array[position].compareTo(temp) == 0 ) {
                    break;
                } else if(array[position].compareTo(temp) == -1) {
                    min = position;
                } else {
                    max = position;
                }

                if(min == max) {
                    break;
                }
            }

            for(int j = i - 1; j > position;j--) {
                array[j+1] = array[j];
            }
            array[position] = temp;
        }
    }

}
