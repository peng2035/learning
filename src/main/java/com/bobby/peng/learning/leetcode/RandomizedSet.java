package com.bobby.peng.learning.leetcode;

import java.util.*;

/**
 * Created by bobby.peng on 2016/9/9.
 */
public class RandomizedSet {

    //https://leetcode.com/problems/insert-delete-getrandom-o1/

    private List<Integer> data;

    private Map<Integer, Integer> indexMap;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        data = new ArrayList<Integer>();
        indexMap = new HashMap<Integer, Integer>();
    }

    /**
     * Inserts a val to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (indexMap.get(val) != null) {
            return false;
        }

        indexMap.put(val, data.size());
        data.add(val);

        return true;
    }

    /**
     * Removes a val from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        Integer index = indexMap.get(val);
        if (index == null) {
            return false;
        }
        if(index == data.size() - 1) {
            indexMap.remove(val);
            data.remove((int)index);
        } else {
            int endValue = data.get(data.size() - 1);
            indexMap.remove(val);
            indexMap.put(endValue,index);

            data.set(index,endValue);
            data.remove(data.size() - 1);
        }
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int size = data.size();

        if (size == 0) {
            throw new RuntimeException("size = 0");
        }
        int random = new Random().nextInt(size);

        return data.get(random);
    }

    public static void main(String[] args) {

        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(-1);
        randomizedSet.insert(-2);
        randomizedSet.remove(-1);
        randomizedSet.getRandom();
    }
}
