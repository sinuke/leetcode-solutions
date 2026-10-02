package com.sinuke.easy;

public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        int max = 1, prev = nums[0], start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev) max = Math.max(max, i - start + 1);
            else start = i;
            prev = nums[i];
        }
        return max;
    }

}
