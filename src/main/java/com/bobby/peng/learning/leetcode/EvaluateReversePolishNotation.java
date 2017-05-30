package com.bobby.peng.learning.leetcode;

import com.bobby.peng.learning.basic.utils.StringUtils;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        int result = 0;
        InnerStack stack = new InnerStack(tokens.length);
        for (int i = 0; i < tokens.length; i++) {
            String value = tokens[i];
            if (tokens[i].equals("+")) {
                result = stack.pop() + stack.pop();
            } else if (tokens[i].equals("-")) {
                int secondValue = stack.pop();
                result = stack.pop() - secondValue;
            } else if (tokens[i].equals("*")) {
                result = stack.pop() * stack.pop();
            } else if (tokens[i].equals("/")) {
                int secondValue = stack.pop();
                result = stack.pop() / secondValue;
            } else {
                result = Integer.valueOf(value);
            }

            stack.push(result);
        }

        return stack.pop();
    }

    public class InnerStack {
        int[] array;

        int currentPointer = -1;

        int size = 0;

        int length;

        public InnerStack(int length) {
            array = new int[length];
            this.length = length;
        }

        public void push(int value) {
            if(currentPointer == length - 1) {
                currentPointer = 0;
            } else {
                currentPointer++;
            }
            array[currentPointer] = value;
            size++;
        }

        public int pop() {
            int value = array[currentPointer];
            if(currentPointer == 0) {
                currentPointer = length - 1;
            } else {
                currentPointer--;
            }
            size--;

            return value;
        }
    }

    public static void main(String[] args) {
        String[] values = StringUtils.buildStringToArray("\"4\",\"-2\",\"/\",\"2\",\"-3\",\"-\",\"-\"");


        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println(evaluateReversePolishNotation.evalRPN(values));
    }
}
