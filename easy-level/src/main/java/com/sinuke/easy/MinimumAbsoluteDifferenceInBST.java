package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        var diff = new Value();
        walk(root, new ArrayList<>(), diff);
        return diff.val;
    }

    private void walk(TreeNode node, List<Integer> lst, Value diff) {
        if (node == null) return;

        walk(node.left, lst, diff);
        if (!lst.isEmpty() && node.val - lst.getLast() < diff.val)
            diff.val = node.val - lst.getLast();
        lst.add(node.val);

        walk(node.right, lst, diff);
    }

    private static class Value {
        int val = Integer.MAX_VALUE;
    }

}
