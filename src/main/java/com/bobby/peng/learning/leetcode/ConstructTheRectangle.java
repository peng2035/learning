package com.bobby.peng.learning.leetcode;

/**
 * Created by bobby.peng on 2017/1/22.
 */
public class ConstructTheRectangle {

    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        double d = Math.sqrt(area);
        for(int i=(int)Math.ceil(d);i<=area;i++) {
            if(area%i==0) {
                int value = (int)area/i;
                result[0] = i;
                result[1] = value;
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ConstructTheRectangle constructTheRectangle = new ConstructTheRectangle();
        constructTheRectangle.constructRectangle(1);
        int s=0,temp=0;
    }
}
