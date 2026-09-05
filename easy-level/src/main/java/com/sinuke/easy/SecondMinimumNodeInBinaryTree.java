package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class SecondMinimumNodeInBinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        int[] mins = new int[2];
        walk(root, new HashSet<>(25), mins);
        return (mins[0] == 0 && mins[1] == 0) || mins[0] == mins[1] || mins[1] == 0 ? -1 : mins[1];
    }

    private void walk(TreeNode node, Set<Integer> set, int[] mins) {
        if (node == null) return;

        if (!set.contains(node.val)) {
            set.add(node.val);
            if (mins[0] == 0) mins[0] = node.val;
            else if (mins[0] > node.val) {
                mins[1] = mins[0];
                mins[0] = node.val;
            } else if (mins[1] == 0 || mins[1] > node.val) mins[1] = node.val;
        }

        walk(node.left, set, mins);
        walk(node.right, set, mins);
    }

}
