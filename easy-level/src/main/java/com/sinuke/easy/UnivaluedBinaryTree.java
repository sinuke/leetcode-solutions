package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

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

}
