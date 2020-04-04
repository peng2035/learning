package com.bobby.peng.learning.java.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bobby.peng on 2018/12/28.
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] result = new int[length][length];
        if((length & 1) == 1)
            result[(length>>1) + 1][(length>>1) + 1] = matrix[(length>>1) + 1][(length>>1) + 1];
        for(int i=0;i<length;i++) {
            for(int j=0;j<length;j++) {
                result[j][length - 1 - i] = matrix[i][j];
            }
        }

        matrix = result;
    }


    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] value = new int[3][3];
        int result = 1;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                value[i][j]= result++;
            }
        }
        rotateImage.rotate(value);

    }
}
