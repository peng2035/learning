package com.bobby.peng.learning.basic.data.structure.test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class PriorityQueueTest {

    static class Entity {
        int value;

        public Entity(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        List<Entity> entities = new ArrayList<>();

        for(int i=0;i<12;i++) {
            entities.add(new Entity(15-i));
        }

        PriorityQueue<Entity> queue = new PriorityQueue<>(entities);

        System.out.println();
    }

}
