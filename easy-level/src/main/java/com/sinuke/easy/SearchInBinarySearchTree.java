package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class SearchInBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (val > root.val) return searchBST(root.right, val);
        else if (val < root.val) return searchBST(root.left, val);
        else return root;
    }

}
