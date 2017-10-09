package com.bobby.peng.learning.java.leetcode;

import com.bobby.peng.learning.java.basic.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2016/12/1.
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;


        List<Integer> nodes = new ArrayList<>();

        buildPath(root, nodes, paths);

        return paths;
    }

    public void buildPath(TreeNode root, List<Integer> originalNodes, List<String> paths) {
        originalNodes.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder path = new StringBuilder();
            path.append(originalNodes.get(0));
            for (int i = 1; i < originalNodes.size(); i++) {
                path.append("->").append(originalNodes.get(i));
            }
            paths.add(path.toString());
            originalNodes.remove(originalNodes.size() - 1);
            return;
        }
        if (root.left != null) {
            buildPath(root.left, originalNodes, paths);
        }

        if (root.right != null) {
            buildPath(root.right, originalNodes, paths);
        }

        originalNodes.remove(originalNodes.size() - 1);

    }

}
