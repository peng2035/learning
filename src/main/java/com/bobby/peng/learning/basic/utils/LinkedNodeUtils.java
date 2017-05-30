package com.bobby.peng.learning.basic.utils;

import com.bobby.peng.learning.basic.data.structure.LinkedNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2016/11/18.
 */
public class LinkedNodeUtils {

    public static LinkedNode buildLinkedNodeList(int[] values) {

        List<LinkedNode> linkedNodes = new ArrayList<>(values.length);
        for(int i=0;i<values.length;i++) {
            LinkedNode linkedNode = new LinkedNode(i);
            linkedNodes.add(linkedNode);
        }
        for(int i=0;i<values.length;i++) {
            linkedNodes.get(i).next = linkedNodes.get(values[i]);
        }

        return linkedNodes.get(0);
    }
}
