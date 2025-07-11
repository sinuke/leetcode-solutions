package com.sinuke.easy;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
         return p != null && q != null
                 ? p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
                 : p == q;
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
