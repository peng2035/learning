package com.bobby.peng.learning.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2018/12/28.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = generateParenthesis(n, n);
        System.out.println(result);

        return result;
    }

    public List<String> generateParenthesis(int n, int right) {
        List<String> result = new ArrayList<>();
        if (n == 0 && right == 0) {
            return null;
        }
        if (n > 0) {
            for (String temp : generateParenthesis(n - 1, right)) {
                result.add("(" + temp);
            }
        }
        if (right > 0 && right > n) {
            List<String> last = generateParenthesis(n, right - 1);
            if (last == null) {
                result.add(")");
            } else {
                for (String temp : last) {
                    result.add(")" + temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis(3);
    }
}
