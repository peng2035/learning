package com.bobby.peng.learning.leetcode;

import com.bobby.peng.learning.basic.data.structure.TreeNode;

/**
 * Created by bobby.peng on 2016/8/26.
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean pFlag = false, qFlag = false;

        if (root == null) {
            return null;
        }

        if (p == null || root.val == p.val) {
            pFlag = true;
        }

        if (q == null || root.val == q.val) {
            qFlag = true;
        }

        if (pFlag == true && qFlag == true) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, pFlag == true ? null : p, qFlag == true ? null : q);
        if (left != null && (pFlag || qFlag) && (p == null || q == null)) {
            return left;
        } else if (left != null && (pFlag || qFlag)) {
            return root;
        }

        TreeNode right = lowestCommonAncestor(root.right, pFlag == true ? null : p, qFlag == true ? null : q);

        if (right != null && (pFlag || qFlag) && (p == null || q == null)) {
            return right;
        } else if (right != null && (pFlag || qFlag)) {
            return root;
        }

        if (left != null && right != null) {
            return root;
        }

        if (left != null || right != null) {
            if (!pFlag && !qFlag) {
                return left != null ? left : right;
            }
        }

        if(pFlag || qFlag) {
            return root;
        } else {
            return null;
        }
    }
}
