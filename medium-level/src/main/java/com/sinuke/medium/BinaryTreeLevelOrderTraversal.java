package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        walk(root, 0, res);
        return res;
    }

    private void walk(TreeNode node, int level, List<List<Integer>> levels) {
        if (node == null) return;

        if (levels.size() == level) levels.add(new ArrayList<>());
        levels.get(level).add(node.val);

        walk(node.left, level + 1, levels);
        walk(node.right, level + 1, levels);
    }

}
