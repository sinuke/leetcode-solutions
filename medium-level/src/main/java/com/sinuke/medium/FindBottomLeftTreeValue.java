package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        var maxLevel = new Value();
        Map<Integer, Deque<Integer>> values = new HashMap<>();
        walk(root, values, 1, maxLevel);
        return values.get(maxLevel.val).getFirst();
    }

    private void walk(TreeNode node, Map<Integer, Deque<Integer>> values, int level, Value maxLevel) {
        if (node == null) return;

        maxLevel.val = Math.max(maxLevel.val, level);
        values.putIfAbsent(level, new LinkedList<>());
        values.get(level).add(node.val);

        walk(node.left, values, level + 1, maxLevel);
        walk(node.right, values, level + 1, maxLevel);
    }

    private static class Value {
        int val;
    }

}
