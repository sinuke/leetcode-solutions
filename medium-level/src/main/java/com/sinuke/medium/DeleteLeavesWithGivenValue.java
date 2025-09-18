package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

public class DeleteLeavesWithGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.val == target && root.left == null && root.right == null) return null;
        walk(root, null, target);
        return root;
    }

    private void walk(TreeNode node, TreeNode parent, int target) {
        if (node == null) return;

        walk(node.left, node, target);
        walk(node.right, node, target);

        if (node.left == null && node.right == null && node.val == target) {
            if (parent.left == node) parent.left = null;
            else if (parent.right == node) parent.right = null;
        }
    }

}
