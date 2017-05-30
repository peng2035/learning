package com.bobby.peng.learning.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ReversePolish {
    final static Set<String> SET = new HashSet<String>();

    static {
        SET.add("+");
        SET.add("-");
        SET.add("*");
        SET.add("/");
    }

    //逆波兰式
    public static double calc(String str) {
        String[] array = str.split(" ");
        if(array.length == 0) {
            throw new RuntimeException("err ");
        }

        Stack<String> stack = new Stack<String>();

        int arrayIndex = 0;
        double value = 0d;
        while(stack.size() > 1 || arrayIndex < array.length) {
            if(SET.contains(array[arrayIndex])) {
                switch (array[arrayIndex].charAt(0)) {
                    case '+' : value = Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop());break;
                    case '-' : value = Double.parseDouble(stack.pop()) - Double.parseDouble(stack.pop());break;
                    case '*' : value = Double.parseDouble(stack.pop()) * Double.parseDouble(stack.pop());break;
                    case '/' : value = Double.parseDouble(stack.pop()) / Double.parseDouble(stack.pop());break;
                    default:break;
                }
                stack.push(Double.toString(value));
                arrayIndex++;
            } else {
                stack.push(array[arrayIndex++]);
            }
        }

        return Double.parseDouble(stack.pop());
    }

    public static void main(String[] args) {
        double value = ReversePolish.calc("6 5 2 3 + 8 * + 3 + *");

        System.out.println("val = " + value);
    }

}
