package com.bobby.peng.learning.java.leetcode;

import com.bobby.peng.learning.java.basic.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bobby.peng on 2017/10/18.
 */
public class LargestRectangleInHistogram {

    class Rectangle {
        int maxArea;
        int currentArea;
        int minHeight;

        public Rectangle(int maxArea, int currentArea, int minHeight) {
            this.maxArea = maxArea;
            this.currentArea = currentArea;
            this.minHeight = minHeight;
        }
    }

    int                     maxArea = 0;
    Map<Integer, Rectangle> map     = new HashMap<>();

    public int largestRectangleArea(int[] heights) {
        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];
            map.put(i, new Rectangle(currentHeight,currentHeight,currentHeight));
            maxArea = Math.max(maxArea,currentHeight);
            for (int m = 0; m < i; m++) {
                Rectangle rectangle = map.get(m);
                if(rectangle.minHeight > currentHeight) {
                    rectangle.currentArea = currentHeight * (i - m + 1);
                    rectangle.maxArea = Math.max(rectangle.currentArea,rectangle.maxArea);
                    rectangle.minHeight = currentHeight;
                } else {
                    rectangle.currentArea += rectangle.minHeight;
                    rectangle.maxArea = Math.max(rectangle.currentArea,rectangle.maxArea);
                }
                maxArea = Math.max(maxArea,rectangle.maxArea);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] array = StringUtils.buildStringToIntArray("5,4,1,2");

        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(array));
    }
}
