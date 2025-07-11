package com.sinuke.easy;

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        return getPath(root, 0, Integer.MAX_VALUE);
    }

    private int getPath(TreeNode node, int depth, int min) {
        if (node == null) return min;

        depth++;

        if (node.left == null && node.right == null) return Math.min(min, depth);
        return Math.min(getPath(node.left, depth, min), getPath(node.right, depth, min));
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
