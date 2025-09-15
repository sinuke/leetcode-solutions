package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

public class BinarySearchTreeToGreaterSumTree {

    public TreeNode bstToGst(TreeNode root) {
        walk(root, new Sum());
        return root;
    }

    private void walk(TreeNode node, Sum sum) {
        if (node == null) return;
        walk(node.right, sum);
        sum.val += node.val;
        node.val = sum.val;

        walk(node.left, sum);
    }

    private static class Sum {
        int val;
    }

}
