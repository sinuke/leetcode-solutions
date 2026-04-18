package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        Value max = new Value();
        walk(root, max);
        return max.val;
    }

    private void walk(TreeNode node, Value max) {
        if (node == null) return;

        walk(node.left, max);
        walk(node.right, max);

        max.val = Math.max(max.val, depth(node.left) + depth(node.right));
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    private static class Value {
        int val;
    }

}
