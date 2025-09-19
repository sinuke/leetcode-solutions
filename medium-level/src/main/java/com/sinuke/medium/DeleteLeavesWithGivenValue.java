package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

public class DeleteLeavesWithGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        walk(root, null, target);
        return (root.val == target && root.left == null && root.right == null) ? null : root;
    }

    private void walk(TreeNode node, TreeNode parent, int target) {
        if (node == null) return;

        walk(node.left, node, target);
        walk(node.right, node, target);

        if (node.left == null && node.right == null && node.val == target) {
            if (parent != null && parent.left == node) parent.left = null;
            else if (parent != null && parent.right == node) parent.right = null;
        }
    }

}
