package com.bobby.peng.learning.java.leetcode;

import com.bobby.peng.learning.java.basic.utils.StringUtils;

/**
 * Created by bobby.peng on 2017/10/24.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int length = height.length;
        int leftMaxIndex = -1, rightMaxIndex = -1;
        int result = 0;
        for (int i = 0, j = length - 1; i < j;) {
            if(height[i] < height[j]) {
                while (leftMaxIndex != -1 && height[i] <= height[leftMaxIndex]) {
                    if (i >= j)
                        return result;
                    i++;
                }
            } else {
                while (rightMaxIndex != -1 && height[j] <= height[rightMaxIndex]) {
                    if (i >= j)
                        return result;
                    j--;
                }
            }
            result = Math.max(result, Math.min(height[i], height[j]) * (j - i));

            leftMaxIndex = i;
            rightMaxIndex = j;
        }

        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        System.out.println(containerWithMostWater.maxArea(StringUtils.buildStringToIntArray("1,2,4,3")));
    }

}
