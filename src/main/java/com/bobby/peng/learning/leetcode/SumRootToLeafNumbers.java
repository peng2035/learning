package com.bobby.peng.learning.leetcode;

import com.bobby.peng.learning.basic.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bobby.peng on 2017/2/16.
 */
public class SumRootToLeafNumbers {

    int result;

    public int sumNumbers(TreeNode root) {
        int num = 0;

        sum(root, num);

        return result;
    }

    public void sum(TreeNode node, int num) {
        if (node == null) {
            return;
        }

        num*=10;
        num+=node.val;
        if (node.left == null && node.right == null) {
            result += num;
        }
        if (node.left != null) {
            sum(node.left, num);
        }

        if (node.right != null) {
            sum(node.right, num);
        }

        num-=node.val;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        for(Map.Entry entry : map.entrySet()) {

        }
    }
}
