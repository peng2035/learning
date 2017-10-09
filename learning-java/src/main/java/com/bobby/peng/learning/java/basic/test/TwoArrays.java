package com.bobby.peng.learning.java.basic.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2017/2/27.
 */
public class TwoArrays {

    public List<Integer> getIntersection(List<Integer> l1,List<Integer> l2) {
        List<Integer> result = new ArrayList<>();
        for(int i=0,j=0;i<l1.size()||j<l2.size();) {
            if(l1.get(i) < l2.get(j)) {
                i++;
            } else if(l1.get(i) == l2.get(j)) {
                result.add(l1.get(i));
                i++;j++;
            } else {
                j++;
            }
        }
        return result;
    }

    public List<Integer> getUnion(List<Integer> l1,List<Integer> l2) {
        List<Integer> result = new ArrayList<>();
        for(int i=0,j=0;i<l1.size()||j<l2.size();) {
            if(l1.get(i) < l2.get(j)) {
                result.add(l1.get(i));
                i++;
            } else if(l1.get(i) == l2.get(j)) {
                result.add(l1.get(i));
                i++;j++;
            } else {
                result.add(l2.get(j));
                j++;
            }
        }
        return result;
    }
}
