package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node == null) return;

        var left = node.left;
        node.left = node.right;
        node.right = left;

        invert(node.left);
        invert(node.right);
    }

}
