package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        Result depth = new Result();
        walk(root, 1, depth);
        Result sum = new Result();
        walk(root, 1, depth.val, sum);
        return sum.val;
    }

    private void walk(TreeNode node, int level, Result depth) {
        if (node == null) return;
        if (node.left == null && node.right == null) depth.val = Math.max(level, depth.val);
        walk(node.left, level + 1, depth);
        walk(node.right, level + 1, depth);
    }

    private void walk(TreeNode node, int level, int target, Result sum) {
        if (node == null) return;
        if (level == target) sum.val += node.val;
        walk(node.left, level + 1, target, sum);
        walk(node.right, level + 1, target, sum);
    }

    private static class Result {
        int val;
    }

}
