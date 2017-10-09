package com.bobby.peng.learning.java.practice;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class MergeSort {

    private int[] data;
    private int[] tempData;

    public MergeSort(int[] data) {
        this.data = data;
        tempData = new int[data.length];
        sort(0, data.length - 1);
    }

    public void sort(int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;

            sort(leftIndex, middleIndex);
            sort(middleIndex + 1, rightIndex);

            merge(leftIndex, rightIndex, middleIndex);
        }
    }

    public void merge(int left, int right, int middle) {
        int leftTemp = left;
        int rightTemp = middle + 1;
        for (int index = left; index <= right; index++) {
            if (leftTemp <= middle && rightTemp <= right) {
                tempData[index] = data[leftTemp] > data[rightTemp] ? data[rightTemp++] : data[leftTemp++];
            } else if (leftTemp <= middle) {
                tempData[index] = data[leftTemp++];
            } else {
                tempData[index] = data[rightTemp++];
            }
        }

        for (int index = left; index <= right; index++) {
            data[index] = tempData[index];
        }
    }

    public int[] getData() {
        return data;
    }

    public static void main(String[] args) {
        int[] a = {3, 8, 3, 2, 7, 10, 23, 1, 4};
        MergeSort mergeSort = new MergeSort(a);
        mergeSort.getData();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
