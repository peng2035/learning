package com.bobby.peng.learning.java.leetcode;

import java.util.Stack;

/**
 * Created by bobby.peng on 2017/10/24.
 */
public class BasicCalculator {

    Stack<String> stack            = new Stack<>();
    String        leftParentheses  = "(";
    String        rightParentheses = ")";
    String        plus             = "+";
    String        minus            = "-";

    public int calculate(String s) {

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if (temp == ' ')
                continue;

            if (temp == '(') {
                stack.push(leftParentheses);
            }

            if (temp == '+') {
                stack.push(plus);
            }

            if (temp == '-') {
                stack.push(minus);
            }

            if (temp > 47 && temp < 58) {
                StringBuilder sb = new StringBuilder();
                do {
                    sb.append(temp);
                    if (++i < s.length()) {
                        temp = s.charAt(i);
                    } else {
                        i++;
                        break;
                    }
                } while (temp > 47 && temp < 58);
                i--;
                stack.push(sb.toString());
                continue;
            }

            if (temp == ')') {
                calculate();
            }
        }
        int tempValue = 0;
        int result = 0;
        while (stack.size() > 0) {
//            if (stack.peek().equals(rightParentheses)) {
//                calculate();
//            }
            if (stack.peek().equals(minus)) {
                result -= tempValue;
            } else if (stack.peek().equals(plus)) {
                result += tempValue;
            } else {
                tempValue = Integer.parseInt(stack.peek());
            }
            stack.pop();
        }

        return result + tempValue;
    }

    private void calculate() {
        Integer value = 0;
        int tempValue = 0;
        while (!stack.peek().equals(leftParentheses)) {
            if (stack.peek().equals(minus)) {
                value -= tempValue;
            } else if (stack.peek().equals(plus)) {
                value += tempValue;
            } else {
                tempValue = Integer.parseInt(stack.peek());
            }
            stack.pop();
        }
        stack.pop();
        value += tempValue;
        stack.push(value.toString());
    }

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();

        basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)");
    }
}
