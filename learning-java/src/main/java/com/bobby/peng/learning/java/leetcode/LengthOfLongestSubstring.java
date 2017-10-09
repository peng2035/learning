package com.bobby.peng.learning.java.leetcode;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLength = 0;
        int temp = 0;
        for (int i = 0; i < s.length() & start < s.length(); i++) {
            boolean flag = true;

            for (int j = start; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    flag = false;
                    if (temp > maxLength) {
                        maxLength = temp;
                    }
                    temp = i - j;
                    start = j + 1;
                    break;
                }
            }
            if (flag) {
                temp++;
            }
        }

        if (temp > maxLength) return temp;
        return maxLength;
    }

}
