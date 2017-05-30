package com.bobby.peng.learning.leetcode;

import com.bobby.peng.learning.basic.data.structure.TreeNode;
import com.bobby.peng.learning.basic.utils.BinaryTreeNodeUtils;

/**
 * Created by bobby.peng on 2016/11/30.
 */
public class DeleteNodeInABST {

    //https://leetcode.com/problems/delete-node-in-a-bst/

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode head = new TreeNode(0);
        head.left = root;
        TreeNode temp = root;
        TreeNode parent = head;
        boolean leftOrNot = true;
        while (temp != null && temp.val != key) {
            parent = temp;
            leftOrNot = temp.val < key ? false : true;
            temp = leftOrNot ? temp.left : temp.right;
        }

        if (temp == null) return root;

        TreeNode findNode = findNode(temp);

        if (leftOrNot) {
            parent.left = findNode;
        } else {
            parent.right = findNode;
        }

        if (findNode == null) return head.left;

        if (temp.left == findNode) {
            if(temp.right != null) {
                findNode.right = temp.right;
            }
        } else if(temp.right == findNode) {
            //todo
        } else {
            findNode.left = temp.left;
            findNode.right = temp.right;
        }

        return head.left;
    }

    public TreeNode findNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return null;
        } else if (node.right == null) {
            return node.left;
        } else if (node.left == null) {
            return node.right;
        } else {
            TreeNode parent = node;
            node = node.left;
            if (node.right == null) {
                return node;
            }
            while (node.right != null) {
                parent = node;
                node = node.right;
            }
            parent.right = node.left;
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeNodeUtils.deserialize("[8,0,31,null,6,28,45,1,7,25,30,32,49,null,4,null,null,9,26,29,null,null,42,47,null,2,5,null,12,null,27,null,null,41,43,46,48,null,3,null,null,10,19,null,null,33,null,null,44,null,null,null,null,null,null,null,11,18,20,null,37,null,null,null,null,14,null,null,22,36,38,13,15,21,24,34,null,null,39,null,null,null,16,null,null,23,null,null,35,null,40,null,17]");

        DeleteNodeInABST deleteNodeInABST = new DeleteNodeInABST();
//        deleteNodeInABST.deleteNode(root, 1);

        deleteNodeInABST.deleteNode(root,49);

        System.out.println(root);
    }
}
