package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class FindModeInBinarySearchTree {

    public int[] findMode(TreeNode root) {
        Value max = new Value();
        Map<Integer, Integer> freq = new HashMap<>();
        walk(root, freq, max);

        return freq.entrySet().stream()
                .filter(e -> e.getValue() == max.val)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    private void walk(TreeNode node, Map<Integer, Integer> freq, Value max) {
        if (node == null) return;

        freq.put(node.val, freq.getOrDefault(node.val, 0) + 1);
        max.val = Math.max(max.val, freq.get(node.val));

        walk(node.left, freq, max);
        walk(node.right, freq, max);
    }

    private static class Value {
        int val;
    }

}
