package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Set<Boolean> results = new HashSet<>();
        walk(root, subRoot, results);
        return results.contains(true);
    }

    private void walk(TreeNode node, TreeNode subRoot, Set<Boolean> results) {
        if (node == null || results.contains(true)) return;

        if (node.val == subRoot.val) {
            results.add(isIdentical(node, subRoot));
        }

        walk(node.left, subRoot, results);
        walk(node.right, subRoot, results);
    }

    private boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        else if (s == null || t == null) return false;

        return s.val == t.val && isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }

}
