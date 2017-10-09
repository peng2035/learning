package com.bobby.peng.learning.java.leetcode;

import com.bobby.peng.learning.java.basic.data.structure.TreeNode;

/**
 * Created by bobby.peng on 2017/1/3.
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        int currentIndex = (startIndex + endIndex ) / 2;
        TreeNode treeNode = new TreeNode(nums[currentIndex]);
        if (startIndex == endIndex) {
            return treeNode;
        }

        treeNode.left = sortedArrayToBST(nums, startIndex, currentIndex - 1);
        treeNode.right = sortedArrayToBST(nums, currentIndex + 1, endIndex);

        return treeNode;
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        for(int i=0;i<10;i++) {
            nums[i] = i;
        }

        ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();
        convertSortedArrayToBinarySearchTree.sortedArrayToBST(nums);
    }

}
