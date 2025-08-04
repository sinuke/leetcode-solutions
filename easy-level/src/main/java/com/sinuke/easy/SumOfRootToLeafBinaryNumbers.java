package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class SumOfRootToLeafBinaryNumbers {

    public int sumRootToLeaf(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        extractValue(root, new StringBuilder(), list);
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private void extractValue(TreeNode node, StringBuilder sb, List<Integer> list) {
        if (node == null) return;

        sb.append(node.val);

        if (node.left == null && node.right == null) {
            list.add(Integer.parseInt(sb.toString(), 2));
            return;
        }

        extractValue(node.left, new StringBuilder(sb), list);
        extractValue(node.right, new StringBuilder(sb), list);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

}
