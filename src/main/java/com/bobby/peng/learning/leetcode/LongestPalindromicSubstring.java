package com.bobby.peng.learning.leetcode;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
//        long seconds = System.currentTimeMillis();
        String result = "";

        int length = 0;
        for (int i = 0; i < s.length() && i + length < s.length(); i++) {
            for (int j = s.length() - 1; j >= i && j - i > length - 1; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    boolean flag = true;
                    for (int m = i + 1, n = j - 1; m < n; m++, n--) {
                        if (s.charAt(m) != s.charAt(n)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        result = s.substring(i, j + 1);
                        length = j - i + 1;
                    }
                }
            }
        }

//        System.out.println(System.currentTimeMillis() - seconds);
        return result;

    }


    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();

        l.longestPalindrome("ab");
    }

}
