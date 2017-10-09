package com.bobby.peng.learning.java.algorithm.dp;

/**
 * Created by bobby.peng on 2016/11/7.
 */
//如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
public class CoinQuestion {

    public static int[] coinTypes = {1,3,5};


    public int getMinValue(int value) {
        if(value == 0) {
            return 0;
        }

        if(value == 1) {
            return 1;
        }
        int min = Integer.MAX_VALUE;

        for(int i=0;i<coinTypes.length;i++) {
            int nextCoin = value - coinTypes[i];
            if(nextCoin < 0) {
                break;
            }

            int times = getMinValue(nextCoin) + 1;

            if(min > times) {
                min = times;
            }
        }

        return min;
    }


    public static void main(String[] args) {
        CoinQuestion coinQuestion = new CoinQuestion();

        for(int i=0;i<12;i++) {
            System.out.println(coinQuestion.getMinValue(i));
        }
    }
}
