package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class BinaryTreeTilt {

    public int findTilt(TreeNode root) {
        sum(root);
        return tilt(root);
    }

    private int sum(TreeNode node) {
        if (node == null) return 0;
        node.val += sum(node.left) + sum(node.right);
        return node.val;
    }

    private int tilt(TreeNode node) {
        if (node == null) return 0;
        int diff = Math.abs((node.left == null ? 0 : node.left.val) - (node.right == null ? 0 : node.right.val));
        return diff + tilt(node.left) + tilt(node.right);
    }

}
