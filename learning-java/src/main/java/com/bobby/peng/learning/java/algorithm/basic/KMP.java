package com.bobby.peng.learning.java.algorithm.basic;

/**
 * Created by peng2035 on 16-11-27.
 */
public class KMP {

    private int[] getNext(String str) {
        char[] chars = str.toCharArray();

        int[] next = new int[chars.length];
        next[0] = 0;
        for (int i = 1; i < str.length(); i++) {

            //if same
            if (chars[i] == chars[next[i]]) {
                next[i] = next[i - 1] + 1;
                continue;
            }

            //if not same
            if (chars[i] != chars[next[i]]) {
                int k = next[i-1];
                while (k > 0 && next[k - 1] > 0) {
                    if (chars[i] == chars[k]) {
                        next[i] = next[k - 1] + 1;
                        break;
                    }
                }
            }

        }
        return next;
    }

    public boolean pattern(String str,String pattern) {
        int[] next = getNext(pattern);

        for(int i=0,j=0;i<str.length();i++) {

            while(j<pattern.length()) {
                if(str.charAt(i) == pattern.charAt(j)) {
                    if(j==pattern.length() -1) return true;
                    i++;j++;
                } else {
                    if(j==0) {
                        j++;
                    } else {
                        j = next[j-1];
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
