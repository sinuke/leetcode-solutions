package com.sinuke.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Integer>> levels = new HashMap<>();
        getValues(root, levels, 0);

        Double[] result = new Double[levels.size()];
        for (var entry : levels.entrySet()) {
            int sum = 0;
            for (int val : entry.getValue()) sum += val;
            result[entry.getKey()] = (sum * 1.0) / entry.getValue().size();
        }
        return Arrays.asList(result);
    }

    private void getValues(TreeNode node, Map<Integer, List<Integer>> levels, int level) {
        if (node == null) return;

        if (levels.containsKey(level)) levels.get(level).add(node.val);
        else {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            levels.put(level, list);
        }

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
