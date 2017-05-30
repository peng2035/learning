package com.bobby.peng.learning.leetcode;

import com.bobby.peng.learning.basic.data.structure.TreeNode;

/**
 * Created by bobby.peng on 2016/11/8.
 */
public class ValidateBinarySearchTree {

    //https://leetcode.com/problems/validate-binary-search-tree/

    public boolean isValidBST(TreeNode node) {
        if(node==null) {
            return true;
        }

        if(node.left!=null) {
            if(node.left.val >= node.val || node.val <= getMaxValue(node.left)) {
                return false;
            } else {
                if(isValidBST(node.left) == false) {
                    return false;
                }
            }
        }
        if(node.right!=null) {
            if(node.right.val <= node.val || node.val >= getMinValue(node.right)) {
                return false;
            } else {
                if(isValidBST(node.right) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    private int getMaxValue(TreeNode node) {

        while(node.right != null) {
            node = node.right;
        }

        return node.val;
    }

    private int getMinValue(TreeNode node) {

        while(node.left != null) {
            node = node.left;
        }

        return node.val;
    }
}
