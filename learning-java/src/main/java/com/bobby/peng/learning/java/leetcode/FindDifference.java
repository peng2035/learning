package com.bobby.peng.learning.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class FindDifference {

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            Integer value = map.get(temp);
            if (value == null) {
                map.put(temp, 1);
            } else {
                map.put(temp, ++value);
            }
        }

        for(int i=0;i<t.length();i++) {
            char temp = t.charAt(i);
            Integer value = map.get(temp);

            if(value == null) return temp;
            if(value == 1) {
                map.remove(temp);
            } else {
                map.put(temp, --value);
            }
        }
        
        return 'a';
    }

}
