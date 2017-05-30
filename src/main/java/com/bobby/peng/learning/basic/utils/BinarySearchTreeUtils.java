package com.bobby.peng.learning.basic.utils;

import com.bobby.peng.learning.basic.data.structure.TreeNode;

/**
 * Created by peng2035 on 16-11-30.
 */
public class BinarySearchTreeUtils {

    public static boolean isBinarySearchTree(TreeNode treeNode) {

        if (treeNode.left == null && treeNode.right == null) {
            return true;
        }

        if (treeNode.left != null) {
            if (treeNode.left.val > treeNode.val)
                return false;
            if(!isBinarySearchTree(treeNode.left))
                return false;
        }

        if(treeNode.right!=null) {
            if(treeNode.right.val < treeNode.val)
                return false;
            if(!isBinarySearchTree(treeNode.right))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        TreeNode node = BinaryTreeNodeUtils.buildTreeByString("[8,0,31,null,6,28,45,1,7,25,30,32,49,null,4,null,null,9,26,29,null,null,42,47,null,2,5,null,12,null,27,null,null,41,43,46,48,null,3,null,null,10,19,null,null,33,null,null,44,null,null,null,null,null,null,null,11,18,20,null,37,null,null,null,null,14,null,null,22,36,38,13,15,21,24,34,null,null,39,null,null,null,16,null,null,23,null,null,35,null,40,null,17]");
//
//        BinaryTreeNodeUtils.buildTreeInConsole("[8,0,31,null,6,28,45,4,7,25,30,32,49,null,5,null,null,9,26,29,null,null,42,47,null,null,null,null,12,null,27,null,null,41,43,46,48,10,19,null,null,33,null,null,44,null,null,null,null,null,11,18,20,null,37,null,null,null,null,14,null,null,22,36,38,13,15,21,24,34,null,null,39,null,null,null,16,null,null,23,null,null,35,null,40,null,17]");

//        System.out.println(isBinarySearchTree(node));
    }

}
