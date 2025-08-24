package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getValues(root, list);

        root = new TreeNode(list.getLast());
        var prev = root;
        for (int i = list.size() - 2; i >= 0; i--) {
            prev.right = new TreeNode(list.get(i));
            prev = prev.right;
        }
        return root;
    }

    private void getValues(TreeNode node, List<Integer> list) {
        if (node == null) return;
        getValues(node.right, list);
        list.add(node.val);
        getValues(node.left, list);
    }

}
