package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        walk(root, null);
        return (root.val == 0 && root.left == null && root.right == null) ? null : root;
    }

    private void walk(TreeNode node, TreeNode parent) {
        if (node == null) return;

        walk(node.left, node);
        walk(node.right, node);

        if (node.val == 0 && node.left == null && node.right == null) {
            if (parent == null) return;
            else if (parent.left == node) parent.left = null;
            else if (parent.right == node) parent.right = null;
        }
    }

}
