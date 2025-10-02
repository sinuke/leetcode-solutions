package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class MaximumLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> sum = new LinkedHashMap<>();
        walk(root, 1, sum);

        int level = 0, max = Integer.MIN_VALUE;
        for (var entry : sum.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                level = entry.getKey();
            }
        }

        return level;
    }

    private void walk(TreeNode node, int level, Map<Integer, Integer> sum) {
        if (node == null) return;

        sum.putIfAbsent(level, 0);
        int curSum = sum.get(level) + node.val;
        sum.replace(level, curSum);

        walk(node.left, level + 1, sum);
        walk(node.right, level + 1, sum);
    }

}
