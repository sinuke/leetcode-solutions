package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        return root == null ? 0 : getPath(root, 0, Integer.MAX_VALUE);
    }

    private int getPath(TreeNode node, int depth, int min) {
        if (node == null) return min;

        depth++;

        if (node.left == null && node.right == null) return Math.min(min, depth);
        return Math.min(getPath(node.left, depth, min), getPath(node.right, depth, min));
    }

}
