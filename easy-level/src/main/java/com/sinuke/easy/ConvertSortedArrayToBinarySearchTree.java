package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int start, int end) {
        if (start > end) return null;
        int middle = (start + end) / 2;
        var node = new TreeNode(nums[middle]);
        node.left = createTree(nums, start, middle - 1);
        node.right = createTree(nums, middle + 1, end);
        return node;
    }

}
