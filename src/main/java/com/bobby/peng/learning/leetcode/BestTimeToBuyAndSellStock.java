package com.bobby.peng.learning.leetcode;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by bobby.peng on 2017/1/9.
 */
public class BestTimeToBuyAndSellStock {

    class Entity implements Comparable<Entity>{

        public Entity(int value, int index) {
            this.value = value;
            this.index = index;
        }

        int value;
        int index;

        @Override
        public int compareTo(Entity o) {
            if(this.value > o.value) {
                return -1;
            } else if(this.value == o.value) {
                if(this.index < o.index) {
                    return 1;
                } else if (this.index > o.index) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return 1;
            }
        }
    }

    public int maxProfit(int[] prices) {
        int max = -1;
        PriorityQueue<Entity> queue = new PriorityQueue<>();

        List<Entity> entities = new ArrayList<>();
        for(int i=0;i<prices.length;i++) {
            entities.add(new Entity(prices[i],i));
        }

        queue.addAll(entities);

        for(int i=0;i<prices.length-1;i++) {
            while(queue.peek() != null && queue.peek().index <= i) {
                queue.poll();
            }
            if(queue.peek() == null) break;
            max = queue.peek().value - prices[i] > max ? queue.peek().value - prices[i] : max;
        }

        return max > 0 ? max : 0;
    }

    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());

        int[] prices = new int[10];
        for(int i=0;i<10;i++) {
            prices[i] = random.nextInt(10);
        }

        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        bestTimeToBuyAndSellStock.maxProfit(prices);
    }

}
