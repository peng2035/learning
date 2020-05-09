package com.bobby.peng.learning.java.leetcode;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int value = numRows+1;
        int times = s.length()/value;
        int lastNums = s.length()%value;
        for(int j=0;j<numRows+1;j++) {
            for(int i=0;i<times;i++) {
                sb.append(s.charAt(value*i+j));
            }
            if(j<lastNums) {
                sb.append(value*times+j);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();

//        System.out.println(zigZagConversion.convert(""));
    }
}
