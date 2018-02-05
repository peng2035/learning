package com.bobby.peng.learning.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 02/02/2018.
 */
public class LetterCombinationsOfAPhoneNumber {

    private static final char[][] TEL = new char[9][4];

    static {
        TEL[0][0] = 'a';
        TEL[0][1] = 'b';
        TEL[0][2] = 'c';
        TEL[1][0] = 'd';
        TEL[1][1] = 'e';
        TEL[1][2] = 'f';
        TEL[2][0] = 'g';
        TEL[2][1] = 'h';
        TEL[2][2] = 'i';
        TEL[3][0] = 'j';
        TEL[3][1] = 'k';
        TEL[3][2] = 'l';
        TEL[4][0] = 'm';
        TEL[4][1] = 'n';
        TEL[4][2] = 'o';
        TEL[5][0] = 'p';
        TEL[5][1] = 'q';
        TEL[5][2] = 'r';
        TEL[5][3] = 's';
        TEL[6][0] = 't';
        TEL[6][1] = 'u';
        TEL[6][2] = 'v';
        TEL[7][0] = 'w';
        TEL[7][1] = 'x';
        TEL[7][2] = 'y';
        TEL[7][3] = 'z';
    }

    boolean isUnderOne = false;

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        char[] temp = new char[digits.length()];
        combine(digits, 0, temp, result);
        return result;
    }

    public void combine(String digital, int index, char[] temp, List<String> result) {

        int telIndex = 0;
        int current = digital.charAt(index) - '2';
        if (current < 0) {
            isUnderOne = true;
            return;
        }
        while (telIndex < 4 && TEL[current][telIndex] > 0) {
            temp[index] = TEL[current][telIndex];
            telIndex++;
            if (index == temp.length - 1) {
                result.add(new String(temp));
                continue;
            }
            combine(digital, index + 1, temp, result);
            if (isUnderOne) return;
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        List<String> result = letterCombinationsOfAPhoneNumber.letterCombinations("7");
        for (String value : result) {
            System.out.println(value);
        }
    }
}
