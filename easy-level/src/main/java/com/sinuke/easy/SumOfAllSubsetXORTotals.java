package com.sinuke.easy;

public class SumOfAllSubsetXORTotals {

    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int result) {
        if (index == nums.length) return result;

        int left = dfs(nums, index + 1, result);
        int right = dfs(nums, index + 1, nums[index] ^ result);
        return left + right;
    }

}
