package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Stat> map = new HashMap<>();
        walk(root, null, 0, map);

        return map.get(x).level == map.get(y).level && map.get(x).parent != map.get(y).parent;
    }

    private void walk(TreeNode node, TreeNode parent, int level, Map<Integer, Stat> map) {
        if (node == null) return;

        var stat = new Stat(level, parent == null ? -1 : parent.val);
        map.put(node.val, stat);

        walk(node.left, node, level + 1, map);
        walk(node.right, node, level + 1, map);
    }

    private record Stat(int level, int parent) {}

}
