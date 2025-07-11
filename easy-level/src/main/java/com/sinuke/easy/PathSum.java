package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        Set<Integer> set = new HashSet<>();
        getPathSum(root, 0, set);
        return set.contains(targetSum);
    }

    private void getPathSum(TreeNode node, int sum, Set<Integer> set) {
        if (node == null) return;

        sum += node.val;

        if (node.left == null && node.right == null) {
            set.add(sum);
            return;
        }

        getPathSum(node.left, sum, set);
        getPathSum(node.right, sum, set);
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
