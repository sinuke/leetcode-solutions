package com.sinuke.easy;

public class MinimumOperationsToMakeTheArrayIncreasing {

    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1] + 1) {
                count += nums[i - 1] + 1 - nums[i];
                nums[i] = Math.max(nums[i - 1] + 1, nums[i]);
            }
        }
        return count;
    }

}
