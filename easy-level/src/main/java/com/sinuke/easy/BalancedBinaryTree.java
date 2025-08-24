package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        Set<Boolean> set = new HashSet<>();
        getHeight(root, set);

        if (set.isEmpty()) return true;
        else return !set.contains(false);
    }

    private int getHeight(TreeNode node, Set<Boolean> result) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;

        int left = getHeight(node.left, result);
        int right = getHeight(node.right, result);
        result.add(Math.abs(left - right) <= 1);
        return Math.max(left, right) + 1;
    }

}
