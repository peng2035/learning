package com.bobby.peng.learning.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bobby.peng on 2016/12/20.
 */
public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {

        int maxLength = 0;
        Map<Integer, Integer> lengthMap = new HashMap<>();
        int lastDeep = 0;
        boolean firstFlag = true;
        boolean fileFlag = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.') {
                fileFlag = true;
            }
            if (input.charAt(i) == 10) {
                if (firstFlag) {
                    lengthMap.put(0, i);
                    firstFlag = false;
                }

                int temp = 0;
                int tempDeep = 0;
                int[] array = findDeep(i, input);
                if (array[0] > lastDeep) {
                    tempDeep = lastDeep;
                    lastDeep = array[0];
                } else if (array[0] == lastDeep) {
                    tempDeep = lastDeep - 1;
                } else {
                    tempDeep = array[0] - 1;
                    lastDeep = array[0];
                }
                if (tempDeep >= 0) {
                    temp = lengthMap.get(tempDeep) + array[1] + 1;
                } else {
                    temp = array[1];
                }
                lengthMap.put(tempDeep + 1, temp);
                if (temp > maxLength && array[3] == 1) {
                    maxLength = temp;
                }
                i = array[2];
                continue;
            }
        }
        if (firstFlag == true && fileFlag) {
            maxLength = input.length();
        }

        return maxLength;
    }

    public int[] findDeep(int index, String input) {
        int deep = 0;
        int startIndex = index + 1;
        int length = 0;
        int endIndex = index + 1;
        int file = 0;
        boolean nFlag = false;
        for (int i = index + 1; i < input.length(); i++) {
            while (input.charAt(i) == 9) {
                deep++;
                i++;
                startIndex = i;
                continue;
            }

            if (input.charAt(i) == '.') {
                file = 1;
            }
            if (input.charAt(i) == 10) {
                length = i - startIndex;
                endIndex = i - 1;
                nFlag = true;
                break;
            }

        }
        if (!nFlag) {
            length = input.length() - startIndex;
            endIndex = input.length() - 1;
        }

        int[] result = new int[]{deep, length, endIndex, file};
        return result;
    }

    public static void main(String[] args) {
        LongestAbsoluteFilePath longestAbsoluteFilePath = new LongestAbsoluteFilePath();
        String value = "rzzmf\nv\n\tix\n\t\tiklav\n\t\t\ttqse\n\t\t\t\ttppzf\n\t\t\t\t\tzav\n\t\t\t\t\t\tkktei\n\t\t\t\t\t\t\thhmav\n\t\t\t\t\t\t\t\tbzvwf.txt";
        int result = longestAbsoluteFilePath.lengthLongestPath(value);
        System.out.println(result);
    }
}
