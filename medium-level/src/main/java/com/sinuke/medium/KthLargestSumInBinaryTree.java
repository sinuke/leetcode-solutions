package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KthLargestSumInBinaryTree {

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sum = new ArrayList<>();
        walk(root, 1, sum);

        if (sum.size() < k) return -1;

        sum.sort(Comparator.reverseOrder());
        return sum.get(k - 1);
    }

    private void walk(TreeNode node, int level, List<Long> sum) {
        if (node == null) return;

        if (level >= sum.size()) sum.add(0L);
        sum.set(level - 1, sum.get(level - 1) + node.val);

        walk(node.left, level + 1, sum);
        walk(node.right, level  + 1, sum);
    }

}
