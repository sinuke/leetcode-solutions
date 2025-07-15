package com.sinuke.easy;

import java.util.Stack;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            var node = stack.pop();
            if (node.left == null && node.right == null && node.val > 1000) sum += node.val - 2000;
            if (node.left != null) {
                node.left.val += 2000;
                stack.push(node.left);
            }
            if (node.right != null) stack.push(node.right);
        }
        return sum;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        return calcSum(root, false);
    }

    private int calcSum(TreeNode node, boolean isLeft) {
        if (node == null) return 0;
        if (isLeft && node.left == null && node.right == null) return node.val;

        return calcSum(node.left, true) + calcSum(node.right, false);
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
