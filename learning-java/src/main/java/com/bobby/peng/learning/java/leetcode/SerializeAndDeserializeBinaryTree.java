package com.bobby.peng.learning.java.leetcode;

import com.bobby.peng.learning.java.basic.data.structure.TreeNode;

/**
 * Created by peng2035 on 16-11-22.
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if (root == null) {
//            return "";
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        StringBuilder sb = new StringBuilder("[");
//        sb.append(root.val);
//        queue.add(root);
//        int levelLength = 1;
//        while (!queue.isEmpty()) {
//            int currentLevelLength = 0;
//            boolean flag = false;
//            StringBuilder sbEachLevel = new StringBuilder();
//            for (int i = 0; i < levelLength; i++) {
//                TreeNode treeNode = queue.poll();
//                TreeNode treeNodeLeft = treeNode.left;
//                if (treeNodeLeft != null) {
//                    queue.add(treeNode.left);
//                    currentLevelLength++;
//                    sbEachLevel.append(",").append(treeNodeLeft.val);
//                    flag = true;
//                } else {
//                    sbEachLevel.append(",null");
//                }
//                TreeNode treeNodeRight = treeNode.right;
//                if (treeNodeRight != null) {
//                    queue.add(treeNodeRight);
//                    currentLevelLength++;
//                    sbEachLevel.append(",").append(treeNodeRight.val);
//                    flag = true;
//                } else {
//                    sbEachLevel.append(",null");
//                }
//            }
//            levelLength = currentLevelLength;
//            if(flag==true) {
//                sb.append(sbEachLevel);
//            }
//        }
//        sb.append("]");
//
//        return sb.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        String[] dataArray = buildDataArray(data);
//
//        if (dataArray == null || dataArray.length == 0) {
//            return null;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        int levelLength = 1;
//        TreeNode head = null;
//        for (int i = 0; i < dataArray.length; ) {
//
//            if (i == 0) {
//                head = new TreeNode(Integer.parseInt(dataArray[0]));
//                queue.add(head);
//                i++;
//                continue;
//            }
//
//            int currentLevelLength = 0;
//            for (int j = 0; j < levelLength; j++) {
//                TreeNode treeNode = queue.poll();
//
//                if (i < dataArray.length && !dataArray[i].equals("null")) {
//                    TreeNode leftNode = treeNode.left = new TreeNode(Integer.parseInt(dataArray[i]));
//                    queue.add(leftNode);
//                    currentLevelLength++;
//                } else if (i >= dataArray.length) {
//                    return head;
//                }
//
//                i++;
//                if (i < dataArray.length && !dataArray[i].equals("null")) {
//                    TreeNode rightNode = treeNode.right = new TreeNode(Integer.parseInt(dataArray[i]));
//                    queue.add(rightNode);
//                    currentLevelLength++;
//                } else if (i >= dataArray.length) {
//                    return head;
//                }
//                i++;
//            }
//
//            levelLength = currentLevelLength;
//        }
//        return head;
//
//    }
//
//    private String[] buildDataArray(String str) {
//        str = str.replace("[", "");
//        str = str.replace("]", "");
//
//        if (str.length() > 0) {
//            return str.split(",");
//        }
//
//        return null;
//
//    }

    private class InnerQueue {

        TreeNode[] treeNodes;

        int currentSize = 0;

        int startIndex = 0;

        int endIndex = -1;

        int maxSize = 0;

        public InnerQueue(int size) {
            treeNodes = new TreeNode[size];
            this.maxSize = size;
        }

        public void add(TreeNode treeNode) {
            if (currentSize >= maxSize) throw new RuntimeException("size too large");

            if (endIndex == maxSize - 1) {
                endIndex = 0;
            } else {
                endIndex++;
            }

            treeNodes[endIndex] = treeNode;
            currentSize++;
        }

        public TreeNode poll() {
            if (currentSize == 0) throw new RuntimeException("is empty");
            TreeNode result = treeNodes[startIndex];
            treeNodes[startIndex] = null;
            if (startIndex == maxSize - 1) {
                startIndex = 0;
            } else {
                startIndex++;
            }

            currentSize--;
            return result;
        }

        public boolean isEmpty() {
            if (currentSize == 0)
                return true;

            return false;
        }
    }
}
