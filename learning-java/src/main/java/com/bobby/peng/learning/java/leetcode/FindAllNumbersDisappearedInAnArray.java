package com.bobby.peng.learning.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2016/11/7.
 */
public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums==null || nums.length<=0){
            return res;
        }
        int len = nums.length;
        for(int i=0;i<len ;i++){
            if (nums[Math.abs(nums[i])-1]>0){
                nums[Math.abs(nums[i])-1] = -1*nums[Math.abs(nums[i])-1];
            }
        }

        for(int i=0;i<len;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;

    }

}
