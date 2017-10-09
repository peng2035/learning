package com.bobby.peng.learning.java.leetcode;

import com.bobby.peng.learning.java.basic.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        sum(root,sum,paths,0);

        return paths;
    }

    public void sum(TreeNode root, int sum, List<List<Integer>> paths, int deep) {
        List<Integer> listLeft = null;
        if (sum - root.left.val == 0 && root.left == null && root.right == null) {
            listLeft = new ArrayList<Integer>();
            listLeft.add(root.left.val);
        } else if (root.left != null && sum - root.left.val > 0) {
            int temp = deep;
            sum(root.left, sum - root.left.val, paths, ++temp);
            if(listLeft != null) {
                listLeft.add(0, root.left.val);
            }
            if(deep == 0) {
                paths.add(listLeft);
            }
        }
        List<Integer> listRight = null;
        if (sum - root.right.val == 0 && root.left == null && root.right == null) {
            listRight = new ArrayList<Integer>();
            listRight.add(root.right.val);
        } else if (root.right != null && sum - root.right.val > 0) {
            int temp = deep;
            sum(root.right, sum - root.right.val, paths, ++temp);
            if(listRight != null) {
                listRight.add(0, root.left.val);
            }
            if(deep == 0) {
                paths.add(listRight);
            }
        }
    }

}
