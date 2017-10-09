package com.bobby.peng.learning.java.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bobby.peng on 2017/1/10.
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
                num+=2;
            } else {
                set.add(c);
            }
        }
        return num + (set.isEmpty() ? 0 : 1);
    }

}

