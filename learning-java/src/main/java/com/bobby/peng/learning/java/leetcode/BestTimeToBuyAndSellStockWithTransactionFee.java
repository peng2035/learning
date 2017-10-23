package com.bobby.peng.learning.java.leetcode;

import com.bobby.peng.learning.java.basic.utils.StringUtils;

/**
 * Created by bobby.peng on 2017/10/23.
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int min = prices[0];
        int max = 0;
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            int current = prices[i];

            if (current <= min) {
                min = current;
                if(max - min > fee) {
                    result += (max - min - fee);
                    min = current;
                    max = 0;
                    continue;
                }
            }

            if (current - min > fee) {
                if (current > max) {
                    if (i == prices.length - 1) {
                        result += (current - min - fee);
                        return result;
                    }
                    max = current;
                }
            }

            if (max - current > fee) {
                if (max - min > fee) {
                    result += (max - min - fee);
                }
                min = current;
                max = 0;
                continue;
            }

        }

        if (max > min) {
            result += (max - min - fee);
        }

        return result;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee b = new BestTimeToBuyAndSellStockWithTransactionFee();

        System.out.println(b.maxProfit(StringUtils.buildStringToIntArray("1,2,1,5,3,5,5,4,1,5"), 0));

    }
}
