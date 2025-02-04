package com.sinuke.easy;

public class MaximumAscendingSubarraySum {

    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0], tmp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) tmp += nums[i];
            else {
                maxSum = Math.max(maxSum, tmp);
                tmp = nums[i];
            }
        }

        return Math.max(maxSum, tmp);
    }

}
