package com.sinuke.easy;

public class EvaluateBooleanBinaryTree {

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) return root.val == 1;
        return root.val == 2
                ? evaluateTree(root.left) || evaluateTree(root.right)
                : evaluateTree(root.left) && evaluateTree(root.right);
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
