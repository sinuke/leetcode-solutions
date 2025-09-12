package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent {

    public int sumEvenGrandparent(TreeNode root) {
        var sum = new Result();
        walk(root, null, null, sum);
        return sum.val;
    }

    private void walk(TreeNode node, TreeNode parent, TreeNode grandParent, Result sum) {
        if (node == null) return;

        if (grandParent != null && grandParent.val % 2 == 0) sum.val += node.val;

        walk(node.left, node, parent, sum);
        walk(node.right, node, parent, sum);
    }

    private static class Result {
        int val;
    }

}
