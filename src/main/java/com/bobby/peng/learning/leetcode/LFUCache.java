package com.bobby.peng.learning.leetcode;

import com.bobby.peng.learning.basic.utils.MethodAndPropUtils;
import com.bobby.peng.learning.constants.GlobalConstants;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by peng2035 on 16-11-24.
 */
public class LFUCache {

    //https://leetcode.com/problems/lfu-cache/

    private int capacity;

    private int currentSize = 0;

    private Map<Integer, Info> infoMap;

    private HashMap<Integer, LinkedHashSet<Integer>> integerLinkedHashSetMap;

    private int minFrequency = 0;

    private class Info {
        int value;

        int frequency;

        public Info() {
        }

        public Info(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
    }

    public LFUCache(int capacity) {
        //DO TEST
        GlobalConstants.METHOD_PARAM_TYPE_MAP.put(this.getClass().getName() + ".get", new Class[]{int.class});
        GlobalConstants.METHOD_PARAM_TYPE_MAP.put(this.getClass().getName() + ".set", new Class[]{int.class, int.class});
        GlobalConstants.CONSTRUCT_PARAM_TYPE_MAP.put(this.getClass().getCanonicalName() + ".LFUCache", new Class[]{int.class});

        this.capacity = capacity;

        this.infoMap = new HashMap<>(capacity);
        this.integerLinkedHashSetMap = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        Info keyInfo = infoMap.get(key);
        if (keyInfo == null) {
            return -1;
        }
        incrFrequencyTimesInMap(key, keyInfo);
        return keyInfo.value;
    }

    public void set(int key, int value) {
        if (capacity == 0) return;

        Info keyInfo = infoMap.get(key);
        if (keyInfo != null) {
            incrFrequencyTimesInMap(key, keyInfo);
            keyInfo.value = value;
            return;
        }

        if (currentSize < capacity) {
            Info info = new Info(value, 0);
            infoMap.put(key, info);

            LinkedHashSet<Integer> set = integerLinkedHashSetMap.get(0);
            if (set == null) {
                set = new LinkedHashSet<>();
                integerLinkedHashSetMap.put(0, set);
                minFrequency = 0;
            }
            set.add(key);

            currentSize++;
        } else {
            Set<Integer> set = integerLinkedHashSetMap.get(minFrequency);
            int topKey = set.iterator().next();
            infoMap.remove(topKey);

            Info info = new Info(value, 0);
            infoMap.put(key, info);

            set.remove(topKey);

            if (set.isEmpty()) {
                integerLinkedHashSetMap.remove(minFrequency);
            }

            LinkedHashSet newSet = integerLinkedHashSetMap.get(0);
            if (newSet == null) {
                newSet = new LinkedHashSet<Integer>();
                integerLinkedHashSetMap.put(0, newSet);
            }
            newSet.add(key);
            minFrequency = 0;

        }
    }

    private void incrFrequencyTimesInMap(int key, Info keyInfo) {
        Set<Integer> set = integerLinkedHashSetMap.get(keyInfo.frequency);
        set.remove(key);
        if (set.size() == 0) {
            if (keyInfo.frequency == minFrequency) {
                minFrequency++;
            }
            deleteMapSet(keyInfo.frequency);
        }

        LinkedHashSet<Integer> linkedHashSet = integerLinkedHashSetMap.get(++keyInfo.frequency);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet<>();
            integerLinkedHashSetMap.put(keyInfo.frequency, linkedHashSet);
        }
        linkedHashSet.add(key);
    }

    private void deleteMapSet(int frequencyValue) {
        integerLinkedHashSetMap.remove(frequencyValue);
    }

    public static void main(String[] args) {

        String[] methodAndProps = new String[2];

        methodAndProps[0] = "[\"LFUCache\",\"set\",\"set\",\"set\",\"set\",\"set\",\"get\",\"set\",\"get\",\"get\",\"set\",\"get\",\"set\",\"set\",\"set\",\"get\",\"set\",\"get\",\"get\",\"get\",\"get\",\"set\",\"set\",\"get\",\"get\",\"get\",\"set\",\"set\",\"get\",\"set\",\"get\",\"set\",\"get\",\"get\",\"get\",\"set\",\"set\",\"set\",\"get\",\"set\",\"get\",\"get\",\"set\",\"set\",\"get\",\"set\",\"set\",\"set\",\"set\",\"get\",\"set\",\"set\",\"get\",\"set\",\"set\",\"get\",\"set\",\"set\",\"set\",\"set\",\"set\",\"get\",\"set\",\"set\",\"get\",\"set\",\"get\",\"get\",\"get\",\"set\",\"get\",\"get\",\"set\",\"set\",\"set\",\"set\",\"get\",\"set\",\"set\",\"set\",\"set\",\"get\",\"get\",\"get\",\"set\",\"set\",\"set\",\"get\",\"set\",\"set\",\"set\",\"get\",\"set\",\"set\",\"set\",\"get\",\"get\",\"get\",\"set\",\"set\",\"set\",\"set\",\"get\",\"set\",\"set\",\"set\",\"set\",\"set\",\"set\",\"set\"]";
        methodAndProps[1] = "[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]";
//        LFUCache lfuCache = new LFUCache(0);
//        lfuCache.set(0,0);
//        lfuCache.get(0);

        try {
            MethodAndPropUtils.parseMethodAndPropUtils(LFUCache.class, methodAndProps);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

//        lfuCache.set(1, 1);
//        lfuCache.set(2, 2);
//        System.out.println(lfuCache.get(1));
//        lfuCache.set(3, 3);
//        System.out.println(lfuCache.get(2));
//        System.out.println(lfuCache.get(3));
//        lfuCache.set(4, 4);
//        System.out.println(lfuCache.get(1));
//        System.out.println(lfuCache.get(3));
//        System.out.println(lfuCache.get(4));
    }

}
