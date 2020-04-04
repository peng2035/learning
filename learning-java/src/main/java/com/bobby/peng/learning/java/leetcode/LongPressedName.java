package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2018/11/1.
 */
public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int i1 = 0, i2 = 0;

        char[] nameChar = name.toCharArray();
        char[] typedChar = typed.toCharArray();

        for (i1 = 0; i1 < nameChar.length && i2 < typedChar.length; i1++) {
            if (typedChar[i2++] != nameChar[i1]) return false;
            if (i1 < nameChar.length -1 && nameChar[i1] != nameChar[i1 + 1]) {
                while (i2 < typedChar.length && typedChar[i2] == nameChar[i1]) {}
            }
        }

        return i2 == typedChar.length && i1 == nameChar.length;
    }

    public static void main(String[] args) {
        LongPressedName longPressedName = new LongPressedName();

        System.out.println(longPressedName.isLongPressedName("alex","aaleex"));
    }

}
