package com.bobby.peng.learning.leetcode;

/**
 * Created by bobby.peng on 2017/2/22.
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int diff = length1 - length2;

        char[] result;
        String temp1,temp2;
        if(length1 > length2) {
            temp1 = num1;
            temp2 = num2;
            result=new char[length1];
        } else {
            temp2 = num1;
            temp1 = num2;
            diff = length2 - length1;
            result = new char[length2];
        }

        boolean flag = false;

        for(int i=temp2.length()-1;i>=0;i--) {
            char temp = (char) (temp1.charAt(diff+i) + temp2.charAt(i) - 48);
            if(flag) {
                temp++;
                flag = false;
            }
            if(temp > 57) {
                flag = true;
                temp = 48;
            }

            result[i+diff] = temp;
        }

        for(int i=diff-1;i>=0;i--) {
            char temp = temp1.charAt(i);

            if(flag) {
                temp++;
                if(temp>57) {
                    temp=48;
                    flag = true;
                } else {
                    flag = false;
                }
            }
            result[i] = temp;
        }

        String value = new String(result);

        if(flag) {
            value = "1" + value;
        }

        return value;
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        addStrings.addStrings("11231214214123413123","12231312312");
    }

}
