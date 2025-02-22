package com.sinuke.easy;

public class RangeSumOfBST {

    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        walk(root, low, high);
        return sum;
    }

    private void walk(TreeNode node, int low, int high) {
        if (node.val >= low && node.val <= high) sum += node.val;
        if (node.left != null) walk(node.left, low, high);
        if (node.right != null) walk(node.right, low, high);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
