package com.bobby.peng.learning.leetcode;

import java.util.*;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class RandomizedCollection {

    private List<Integer> data;

    private Map<Integer, Set<Integer>> indexMap;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        data = new ArrayList<Integer>();
        indexMap = new HashMap<Integer, Set<Integer>>();
    }

    /**
     * Inserts a val to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        data.add(val);
        Set<Integer> list = indexMap.get(val);

        if (list == null) {
            list = new LinkedHashSet<>();
            list.add(data.size() - 1);
            indexMap.put(val, list);
            return true;
        } else {
            list.add(data.size() - 1);
            return false;
        }
    }

    /**
     * Removes a val from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        Set<Integer> indexes = indexMap.get(val);

        if (indexes == null || indexes.size() == 0) {
            return false;
        } else {

            int index = indexes.iterator().next();

            int bottom = data.size() - 1;
            indexes.remove(index);
            if(index != bottom) {
                int changedValue = data.get(bottom);
                data.set(index ,changedValue);
                Set<Integer> changedIndexes = indexMap.get(changedValue);

                changedIndexes.remove(data.size() - 1);
                changedIndexes.add(index);
            }
            data.remove(bottom);
            return true;
        }
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int size = data.size();

        if (size == 0) {
            throw new RuntimeException("size = 0");
        }
        int random = new Random().nextInt(size);

        return data.get(random);
    }

    @Override
    public String toString() {
        System.out.println(data);
        System.out.println(indexMap);
        return null;
    }

    public static void main(String[] args) {

        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(4);
        randomizedCollection.toString();
        randomizedCollection.insert(4);
        randomizedCollection.toString();
        randomizedCollection.insert(4);
        randomizedCollection.toString();
        randomizedCollection.insert(4);
        randomizedCollection.toString();
        randomizedCollection.remove(4);
        randomizedCollection.toString();
        randomizedCollection.remove(4);
        randomizedCollection.toString();
        randomizedCollection.remove(4);
        randomizedCollection.toString();
        randomizedCollection.remove(4);
        randomizedCollection.toString();
        randomizedCollection.getRandom();
    }
}
