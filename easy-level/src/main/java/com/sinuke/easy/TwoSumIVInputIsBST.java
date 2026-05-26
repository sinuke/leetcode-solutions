package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

import java.util.HashSet;
import java.util.Set;

class TwoSumIVInputIsBST {

    public boolean findTarget(TreeNode root, int k) {
        Value result = new Value();
        result.val = false;
        walk(root, new HashSet<>(), k, result);
        return result.val;
    }

    private void walk(TreeNode node, Set<Integer> set, int k, Value result) {
        if (node == null || result.val) return;
        if (set.contains(k - node.val)) {
            result.val = true;
            return;
        }

        set.add(node.val);

        walk(node.left, set, k, result);
        walk(node.right, set, k, result);
    }

    private static class Value {
        boolean val;
    }

}
