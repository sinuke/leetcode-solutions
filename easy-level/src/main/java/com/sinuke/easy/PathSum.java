package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        Set<Integer> set = new HashSet<>();
        getPathSum(root, 0, set);
        return set.contains(targetSum);
    }

    private void getPathSum(TreeNode node, int sum, Set<Integer> set) {
        if (node == null) return;

        sum += node.val;

        if (node.left == null && node.right == null) {
            set.add(sum);
            return;
        }

        getPathSum(node.left, sum, set);
        getPathSum(node.right, sum, set);
    }

}
