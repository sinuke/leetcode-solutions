package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteNodesAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = Arrays.stream(to_delete).boxed()
                .collect(Collectors.toCollection(HashSet::new));
        List<TreeNode> result = new ArrayList<>(1000);
        if (root != null && !toDelete.contains(root.val)) result.add(root);
        walk(root, null, toDelete, result);
        return result;
    }

    private void walk(TreeNode node, TreeNode parent, Set<Integer> toDelete, List<TreeNode> result) {
        if (node == null) return;

        walk(node.left, node, toDelete, result);
        walk(node.right, node, toDelete, result);

        if (toDelete.contains(node.val)) {
            if (parent != null) {
                if (parent.left == node) parent.left = null;
                else if (parent.right == node) parent.right = null;
            }

            if (node.left != null) result.add(node.left);
            if (node.right != null) result.add(node.right);

            node.left = null;
            node.right = null;
        }
    }

}
