package com.bobby.peng.learning.leetcode;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;

        if(timeSeries.length == 0) return result;

        int last = timeSeries[0];
        for(int i=1;i<timeSeries.length;i++) {
            int value = timeSeries[i] - last > duration ? duration : timeSeries[i] - last;
            last = timeSeries[i];
            result += value;
        }

        return result + duration;
    }

}
