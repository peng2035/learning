package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/10/24.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] sValue = new int[128];
        int[] tValue = new int[128];

        for (int i = 0; i < s.length(); i++) {
            int sTemp = s.charAt(i);
            int tTemp = t.charAt(i);
            if (sValue[sTemp] == tValue[tTemp]) {
                sValue[sTemp] = i + 1;
                tValue[tTemp] = i + 1;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();

        isomorphicStrings.isIsomorphic("add", "egg");
    }

}
