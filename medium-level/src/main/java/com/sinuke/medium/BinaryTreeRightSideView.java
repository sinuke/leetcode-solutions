package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        walk(root, 1, result);
        return result;
    }

    private void walk(TreeNode node, int level, List<Integer> levels) {
        if (node == null) return;

        if (levels.size() < level) levels.add(node.val);
        else levels.set(level - 1, node.val);

        walk(node.left, level + 1, levels);
        walk(node.right, level + 1, levels);
    }

}
