package com.bobby.peng.learning.java.leetcode;

/**
 * Created by peng2035 on 2017/3/31.
 */
public class ComplexNumberMultiplication {

    //todo better

    public String complexNumberMultiply(String a, String b) {
        int aPlusIndex = a.indexOf("+"),bPlusIndex = b.indexOf("+");

        String result = computeMulti(a.substring(0,aPlusIndex),b.substring(0,bPlusIndex));
        result = computeAdd(result,computeMulti(a.substring(aPlusIndex+1,a.length()),b.substring(0,bPlusIndex)));
        result = computeAdd(result,computeMulti(a.substring(aPlusIndex+1,a.length()),b.substring(bPlusIndex+1,b.length())));
        result = computeAdd(result,computeMulti(a.substring(0,aPlusIndex),b.substring(bPlusIndex+1,b.length())));

        return result;
    }

    public String computeMulti(String m1,String m2) {
        int value = 0,iValue = 0;
        int m1Index = m1.indexOf("i"), m2Index = m2.indexOf("i");
        if(m1Index == -1 && m2Index == -1) {
            value = Integer.valueOf(m1) * Integer.valueOf(m2);
        } else if(m1Index == -1) {
            iValue = Integer.valueOf(m1) * Integer.valueOf(m2.substring(0,m2Index));
        } else if(m2Index == -1) {
            iValue = Integer.valueOf(m2) * Integer.valueOf(m1.substring(0,m1Index));
        } else {
            value = Integer.valueOf(m1.substring(0,m1Index)) * Integer.valueOf(m2.substring(0,m2Index));
            value *= -1;
        }
        return value + "+" + iValue + "i";
    }

    public String computeAdd(String m1,String m2) {
        int value = 0,iValue = 0;
        int m1PlusIndex = m1.indexOf("+"),m2PlusIndex = m2.indexOf("+");
        value = Integer.valueOf(m1.substring(0,m1PlusIndex)) + Integer.valueOf(m2.substring(0,m2PlusIndex));
        iValue = Integer.valueOf(m1.substring(m1PlusIndex + 1,m1.length() - 1)) +
                Integer.valueOf(m2.substring(m2PlusIndex + 1,m2.length() - 1));

        return value + "+" + iValue + "i";
    }
    
    public static void main(String[] args) {
        ComplexNumberMultiplication complexNumberMultiplication = new ComplexNumberMultiplication();

        complexNumberMultiplication.complexNumberMultiply("1+1i","1+1i");
    }

}
