package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        getValues(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        getValues(root2, list2);

        return list1.equals(list2);
    }

    private void getValues(TreeNode node, List<Integer> list) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        getValues(node.left, list);
        getValues(node.right, list);
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
