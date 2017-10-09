package com.bobby.peng.learning.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2017/2/6.
 */
public class KeyboardRow {

    public String[] findWords(String[] words) {
        int[] values = new int[128];
        init(values);
        List<String> result = new ArrayList<>();
        for(String word : words) {
            int temp = 0;
            boolean flag = true;
            for(int i=0;i<word.length();i++) {
                int ascii = word.charAt(i) < 97 ? word.charAt(i) + 32 : word.charAt(i);
                if(i == 0) {
                    temp = values[ascii];
                } else {
                    if(values[ascii] != temp) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                result.add(word);
            }
        }


        String[] s = new String[result.size()];
        return result.toArray(s);
    }

    private void init(int[] values) {
        values['q'] = 1;
        values['w'] = 1;
        values['e'] = 1;
        values['r'] = 1;
        values['t'] = 1;
        values['y'] = 1;
        values['u'] = 1;
        values['i'] = 1;
        values['o'] = 1;
        values['p'] = 1;
        values['a'] = 2;
        values['s'] = 2;
        values['d'] = 2;
        values['f'] = 2;
        values['g'] = 2;
        values['h'] = 2;
        values['j'] = 2;
        values['k'] = 2;
        values['l'] = 2;
        values['z'] = 3;
        values['x'] = 3;
        values['c'] = 3;
        values['v'] = 3;
        values['b'] = 3;
        values['n'] = 3;
        values['m'] = 3;
    }

    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.findWords(words);

    }
}
