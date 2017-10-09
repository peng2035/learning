package com.bobby.peng.learning.java.algorithm;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class BinarySearch {

    //折半查找
    //数据结构与算法分析 p34

    public static int binarySearch(int a[],int x) {
        int left = 0,right = a.length - 1;

        while(left < right) {
            int middle = (left + right) / 2;

            if(x == a[middle]) {
                return middle;
            } else if (x > a[middle]){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
