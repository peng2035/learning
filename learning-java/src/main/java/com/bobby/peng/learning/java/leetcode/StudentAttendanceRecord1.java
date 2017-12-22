package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/12/18.
 */
public class StudentAttendanceRecord1 {

    public boolean checkRecord(String s) {
        int[] value = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                value[1] = 0;
                if (value[0] == 0) {
                    value[0]++;
                } else {
                    return false;
                }
            } else if (s.charAt(i) == 'L') {
                if (value[1] < 2) {
                    value[1]++;
                } else {
                    return false;
                }
            } else {
                value[1] = 0;
            }
        }
        return true;
    }

}
