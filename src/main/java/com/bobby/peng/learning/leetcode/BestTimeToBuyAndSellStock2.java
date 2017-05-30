package com.bobby.peng.learning.leetcode;

/**
 * Created by bobby.peng on 2017/1/9.
 */
public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                max = max + diff;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int[] prices = {1, 2};

        BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStock2();

        System.out.println(bestTimeToBuyAndSellStock2.maxProfit(prices));
    }

}
