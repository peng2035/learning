package com.bobby.peng.learning.java.algorithm;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class MaxSubSum {

    //最大子序列和问题
    //详见数据结构和算法分析 2.4.3 p28
    public static int getMaxSubSum(int[] a) {
        if (a.length == 0) {
            throw new RuntimeException("array is empty");
        }

        int left = 0;
        int right = a.length - 1;

        return getMaxSubSum(a, left, right);
    }

    public static int getMaxSubSum(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }

        int middle = (left + right) / 2;
        int leftCrossMiddleMax = a[middle],leftTemp = a[middle] ;
        for (int i = middle - 1; left <= i; i--) {
            leftTemp += a[i];
            if(leftCrossMiddleMax < leftTemp ) {
                leftCrossMiddleMax = leftTemp;
            }
        }

        int rightCrossMiddleMax = a[middle+1],rightTemp = a[middle+1];
        for (int i = middle + 2; right >= i; i++) {
            rightTemp += a[i];
            if(rightCrossMiddleMax < rightTemp ) {
                rightCrossMiddleMax = rightTemp;
            }
        }

        int middleMax = rightCrossMiddleMax + leftCrossMiddleMax;

        int leftMax = getMaxSubSum(a,left,middle);
        int rightMax = getMaxSubSum(a,middle+1,right);

        return max3(middleMax,leftMax,rightMax);
    }

    public static int max3(int middleMax,int leftMax,int rightMax) {
        int maxTemp = middleMax > leftMax ? middleMax : leftMax;
        maxTemp = maxTemp > rightMax ? maxTemp : rightMax;

        return maxTemp;
    }

    public static void main(String[] args) {
        int[] a = {2,-9,3,5,-7,8};

        System.out.println(MaxSubSum.getMaxSubSum(a));
    }
}
