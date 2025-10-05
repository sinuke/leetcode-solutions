package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> freq = new HashMap<>();
        var max = new Value();
        walk(root, freq, max);

        return freq.entrySet().stream()
                .filter(e -> e.getValue().equals(max.val))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    private int walk(TreeNode node, Map<Integer, Integer> freq, Value max) {
        if (node == null) return 0;

        int sum = node.val + walk(node.left, freq, max) + walk(node.right, freq, max);
        freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        max.val = Math.max(max.val, freq.get(sum));
        return sum;
    }

    private static class Value {
        int val;
    }

}
