package com.sinuke.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer,long[]> levels = new HashMap<>();
        getValues(root, levels, 0);

        Double[] result = new Double[levels.size()];
        for (var entry : levels.entrySet()) {
            result[entry.getKey()] = (entry.getValue()[0] * 1.0) / entry.getValue()[1];
        }
        return Arrays.asList(result);
    }

    private void getValues(TreeNode node, Map<Integer, long[]> levels, int level) {
        if (node == null) return;

        if (levels.containsKey(level)) {
            levels.get(level)[0] += node.val;
            levels.get(level)[1] += 1;
        }
        else levels.put(level, new long[]{node.val, 1});

        getValues(node.left, levels, level + 1);
        getValues(node.right, levels, level + 1);
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
