package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rows = new ArrayList<>();
        walk(root, 1, rows);
        return rows;
    }

    private void walk(TreeNode node, int level, List<Integer> rows) {
        if (node == null) return;

        if (level > rows.size()) rows.add(Integer.MIN_VALUE);
        rows.set(level - 1, Math.max(node.val, rows.get(level - 1)));

        walk(node.left, level + 1, rows);
        walk(node.right, level + 1, rows);
    }

}
