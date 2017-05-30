package com.bobby.peng.learning.leetcode;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() == 1) return false;

        char[] array = new char[str.length()];
        int currentArraySize = 1;

        array[0] = str.charAt(0);

        int index = -1;
        for (int i = 1; i < str.length(); i++) {
            array[i] = str.charAt(i);
            if (str.charAt(i) == array[0]) {
                boolean flag = true;
                i++;
                for (int j = 1; j < currentArraySize; j++, i++) {

                    if (i == str.length()) return false;
                    char a = str.charAt(i);
                    array[i] = a;
                    if(index == -1 && a == array[0]) {
                        index = i;
                    }
                    if (a != array[j]) {
                        flag = false;
                        if(index != -1) {
                            i = index - 1;
                            currentArraySize = index;
                            index = -1;
                        } else {
                            currentArraySize = i + 1;
                        }
                        break;
                    }
                }
                if (flag && i == str.length()) {
                    return true;
                } else if (flag) {
                    i--;
                }
            } else {
                currentArraySize = i + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();

        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("babbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabb"));
    }

}
