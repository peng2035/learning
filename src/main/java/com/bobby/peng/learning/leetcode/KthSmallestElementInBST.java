package com.bobby.peng.learning.leetcode;

import com.bobby.peng.learning.basic.data.structure.TreeNode;

/**
 * Created by bobby.peng on 2016/12/1.
 */
public class KthSmallestElementInBST {

    private int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        int result = find(root, k).val;
        return result;
    }

    public TreeNode find(TreeNode root, int k) {

        if (root == null) return null;

        if (root.left == null && root.right == null) {
            index++;
            if (index == k) return root;
            else return null;
        }

        TreeNode leftResult = find(root.left, k);

        if (leftResult != null) return leftResult;

        index++;
        if (index == k) return root;

        return find(root.right, k);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);

        KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();
        System.out.println(kthSmallestElementInBST.kthSmallest(treeNode, 2));
    }
}
