package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        getPath(root, new StringBuilder(), result);
        return result;
    }

    private void getPath(TreeNode node, StringBuilder path, List<String> result) {
        if (node == null) return;

        if (!path.isEmpty()) path.append("->");
        path.append(node.val);

        if (node.left == null && node.right == null) {
            result.add(path.toString());
            return;
        }

        getPath(node.left, new StringBuilder(path), result);
        getPath(node.right, new StringBuilder(path), result);
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
