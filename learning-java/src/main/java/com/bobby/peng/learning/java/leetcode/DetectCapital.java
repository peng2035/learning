package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 02/02/2018.
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        boolean headCapital = false;
        boolean otherCapital = false;
        for (int i = 0; i < word.length(); i++) {
            char value = word.charAt(i);
            if (!isLetter(value)) return false;

            if (i == 0) {
                headCapital = isCapital(value);
            } else {
                if (headCapital && !isCapital(value) && otherCapital) {
                    return false;
                } else if (headCapital && !otherCapital && isCapital(value)) {
                    if (i == 1) otherCapital = true;
                    else return false;
                } else if (headCapital && otherCapital && !isCapital(value)) {
                    return false;
                } else if (!headCapital && isCapital(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCapital(char value) {
        return value >= 65 && value <= 90;
    }

    public boolean isLetter(char value) {
        return isCapital(value) || (value >= 97 && value <= 122);
    }

    public static void main(String[] args) {
        DetectCapital detectCapital = new DetectCapital();

        System.out.println(detectCapital.detectCapitalUse("uSA"));
    }
}
