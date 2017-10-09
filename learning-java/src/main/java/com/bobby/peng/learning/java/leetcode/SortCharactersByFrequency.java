package com.bobby.peng.learning.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bobby.peng on 2016/12/6.
 */
public class SortCharactersByFrequency {

    class LinkedValue {
        LinkedValue next;

        char value;

        public LinkedValue(LinkedValue next, char value) {
            this.next = next;
            this.value = value;
        }
    }

    public String frequencySort(String s) {
        int maxValue = 0;
        int minValue = s.length();
        LinkedValue[] linkedValues = new LinkedValue[s.length()];

        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char value = s.charAt(i);
            Integer frequency = frequencyMap.get(value);
            if(frequency==null) {
                frequencyMap.put(value,1);
            } else {
                frequencyMap.put(value,++frequency);
            }
        }

        for(Map.Entry<Character,Integer> entry : frequencyMap.entrySet()) {
            int value = entry.getValue();
            char key = entry.getKey();
            LinkedValue linkedValue = new LinkedValue(linkedValues[value],key);
            linkedValues[value] = linkedValue;
            if(value>maxValue) maxValue = value;
            if(value<minValue) minValue = value;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=maxValue;i>=minValue;i--) {
            LinkedValue temp = linkedValues[i];
            while(temp!=null) {
                for(int j=0;j<i;j++) {
                    sb.append(temp.value);
                }
                temp=temp.next;
            }
        }
        return sb.toString();
    }

}
