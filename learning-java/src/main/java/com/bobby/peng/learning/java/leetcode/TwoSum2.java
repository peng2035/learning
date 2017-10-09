package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/1/8.
 */
public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int min = target - numbers[numbers.length - 1];
        for(int i=0;i<numbers.length - 1;i++) {
            if(numbers[i] < min) continue;

            if(numbers[i] * 2 > target) return null;
            int index = findNext(target - numbers[i],i+1,numbers);
            if(index == -1) {
                continue;
            }

            int[] result = {i+1,index+1};
            return result;
        }
        return null;
    }

    public int findNext(int value,int startIndex,int[] numbers) {
        int left = startIndex,right = numbers.length - 1;

        while(left <= right) {
            int middle = (left + right) / 2;

            if(value == numbers[middle]) {
                return middle;
            } else if (value > numbers[middle]){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        TwoSum2 twoSum2 = new TwoSum2();
        int[] nums = {2,3,6,7};
        twoSum2.twoSum(nums,9);
    }
}
