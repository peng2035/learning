package com.bobby.peng.learning.java.leetcode;

import org.apache.ignite.internal.util.GridBoundedPriorityQueue;
import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

/**
 * Created by bobby.peng on 2017/10/16.
 */
public class RemoveKDigits {

    class Point implements Comparable<Point> {
        public int index;
        public int value;

        public Point(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(@NotNull Point o) {
            if (this.value < o.value) {
                return -1;
            }

            if (this.value > o.value) {
                return 1;
            }

            return this.index - o.index;
        }
    }

    public String removeKdigits(String num, int k) {

        if(num.length() == k) return "0";
        if(k==0) return num;

        int zeroNum = 0;
        int zeroIndex = -1;
        int usedIndex = -1;
        if (k == 0) {
            return num;
        }

        boolean[] indexes = new boolean[num.length()];
        PriorityQueue<Point> queue = new PriorityQueue<>(num.length());
        for (int i = 0; i < num.length(); i++) {
            char value = num.charAt(i);
            if (value - 48 == 0) {
                if (i - zeroNum < k) {
                    zeroNum++;
                    zeroIndex = i;
                    usedIndex = i;
                    continue;
                }
            }
            queue.add(new Point(i, value - 48));
            if (i >= k) {
                Point point = findPoint(queue, usedIndex);
                usedIndex = point.index;
                indexes[usedIndex] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        boolean headZero = true;
        for (int i = zeroIndex + 1; i < num.length(); i++) {
            if (indexes[i]) {
                char value = num.charAt(i);
                if (headZero && value - 48 == 0) {
                    continue;
                } else {
                    headZero = false;
                }
                result.append(num.charAt(i));
            }
        }

        String value = result.toString();
        if(value.length() == 0) {
            return "0";
        } else {
            return value;
        }
    }

    public Point findPoint(PriorityQueue<Point> queue, int index) {
        while (true) {
            Point point = queue.poll();
            if (point.index > index) {
                return point;
            }
        }
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKdigits("10", 2));
    }
}
