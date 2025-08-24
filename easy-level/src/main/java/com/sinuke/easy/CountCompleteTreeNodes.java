package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + (root.left == null ? 0 : countNodes(root.left)) + (root.right == null ? 0 : countNodes(root.right));
    }

}
