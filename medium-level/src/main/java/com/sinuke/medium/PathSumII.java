package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        getSum(root, targetSum, 0, new ArrayList<>(), result);
        return result;
    }

    private void getSum(TreeNode node, int target, int curSum, List<Integer> curPath, List<List<Integer>> result) {
        if (node == null) return;

        curSum += node.val;
        curPath.add(node.val);

        if (node.left == null && node.right == null) {
            if (curSum == target) result.add(curPath);
        } else {
            getSum(node.left, target, curSum, new ArrayList<>(curPath), result);
            getSum(node.right, target, curSum, new ArrayList<>(curPath), result);
        }
    }

}
