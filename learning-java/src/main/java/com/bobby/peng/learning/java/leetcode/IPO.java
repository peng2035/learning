package com.bobby.peng.learning.java.leetcode;

import java.util.*;

/**
 * Created by bobby.peng on 2017/2/6.
 */
public class IPO {

    class QueueNode implements Comparable<QueueNode> {
        int index;
        int value;

        public QueueNode(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(QueueNode o) {
            return o.value - this.value;
        }
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        PriorityQueue<QueueNode> indexQueue = new PriorityQueue<>();

        int result = W;
        if (W > Capital[Capital.length - 1] && k >= Capital.length) {
            for (int i = 0; i < Profits.length; i++) {
                result += Profits[i];
            }
            return result;
        }

//        int top = 0;
        for (int i = 0; i < Profits.length; i++) {
            PriorityQueue<Integer> queue = map.get(Capital[i]);

            if (queue == null) {
                queue = new PriorityQueue<>((o1, o2) -> (o2 - o1));
                map.put(Capital[i], queue);
            }

//            top = top < Capital[i] ? Capital[i] : top;
            queue.add(Profits[i]);
        }


        int last = -1;

        for (int i = 0; i < k; i++) {
            //load num
            for (int temp = result; temp > last; temp--) {
                Queue<Integer> queue = map.get(temp);
                if (queue != null) {
                    indexQueue.add(new QueueNode(temp, queue.poll()));
                }
            }
            last = result;

            QueueNode queueNode = indexQueue.poll();
            if (queueNode == null) {
                return result;
            }

            Queue<Integer> selectedQueue = map.get(queueNode.index);

            if (selectedQueue.size() != 0) {
                indexQueue.add(new QueueNode(queueNode.index, selectedQueue.poll()));
            }

            result += queueNode.value;
        }

        return result;
    }

    public static void main(String[] args) {
//        IPO ipo = new IPO();
//        int[] pro = {1};
//        int[] cap = {1};
//
//        long time = System.currentTimeMillis();
//        System.out.println(ipo.findMaximizedCapital(50000, 50000, pro, cap));
//        System.out.println(System.currentTimeMillis() - time);

        String value = "CREATE INDEX IX_ORD_DRAFT_ORDER_%02d ON XIMA_ORD.ORD_DRAFT_ORDER_%02d (USER_ID);";

        for(int i=0;i<100;i++) {
            System.out.println(String.format(value,i,i));
        }
    }
}
