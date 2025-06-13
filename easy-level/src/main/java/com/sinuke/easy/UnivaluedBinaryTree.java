package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        getValue(root, set);
        return set.size() == 1;
    }

    private void getValue(TreeNode root, Set<Integer> set) {
        if (root == null) return;

        set.add(root.val);
        getValue(root.left, set);
        getValue(root.right, set);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

}
