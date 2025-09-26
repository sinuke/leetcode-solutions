package com.sinuke.medium;

import com.sinuke.common.data.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        walk(root, 1, result);
        return result;
    }

    private void walk(Node node, int level, List<List<Integer>> result) {
        if (node == null) return;

        if (level > result.size()) result.add(new ArrayList<>());
        result.get(level - 1).add(node.val);

        for (var n : node.children) {
            walk(n, level + 1, result);
        }
    }

}
