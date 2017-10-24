package com.bobby.peng.learning.java.leetcode;

import com.bobby.peng.learning.java.basic.utils.StringUtils;

/**
 * Created by bobby.peng on 2017/10/24.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int length = height.length;
        int leftMax = height[0], rightMax = height[length - 1], leftMaxIndex = 0, rightMaxIndex = length - 1;
        int result = Math.min(leftMax, rightMax) * (rightMaxIndex - leftMaxIndex);
        for (int i = 1, j = height.length - 2; i < j;) {

            while (height[i] <= leftMax) {
                if (i >= j)
                    return result;
                i++;
            }

            int area = Math.min(height[i], rightMax) * (rightMaxIndex - i);
            if (area > result) {
                result = area;
                leftMax = height[i];
                leftMaxIndex = i++;
                continue;
            }

            while (height[j] <= rightMax && i < j) {
                if (i >= j)
                    return result;
                j--;
            }

            area = Math.min(height[leftMaxIndex], height[j]) * (j - leftMaxIndex);
            int area2 = Math.min(height[i], height[j]) * (j - i);
            if (area > area2) {
                rightMax = height[j];
                rightMaxIndex = j;
                i = leftMaxIndex + 1;
                if (result < area) {
                    result = area;
                }
            } else {
                rightMax = height[j];
                rightMaxIndex = j;
                i++;
                if (result < area2) {
                    result = area2;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        System.out.println(containerWithMostWater.maxArea(StringUtils.buildStringToIntArray("2,3,4,5,18,17,6")));
    }

}
