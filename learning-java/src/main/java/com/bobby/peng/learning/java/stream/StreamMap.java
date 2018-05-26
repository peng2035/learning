package com.bobby.peng.learning.java.stream;

import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by bobby.peng on 2018/4/19.
 */
public class StreamMap {

    public static List<Integer> newRandomList() {
        List<Integer> list = new ArrayList<>(50);
        for(int i=0;i<50;i++) {
            list.add(i);
        }
        return list;
    }

    public static void printOut(List<Integer> list) {
        list.stream().forEach(StreamMap::println);
    }

    public static void println(int i) {
        System.out.println(i);
    }

    public static void main(String[] args) {
        List<Integer> list = StreamMap.newRandomList();

        List<Integer> list2 = list.stream().map(i->i*5).collect(Collectors.toList());

        StreamMap.printOut(list2);

    }

}
