package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        walk(root, list);
        return list.get(k - 1);
    }

    private void walk(TreeNode node, List<Integer> list) {
        if (node == null) return;
        walk(node.left, list);
        list.add(node.val);
        walk(node.right, list);
    }

}
