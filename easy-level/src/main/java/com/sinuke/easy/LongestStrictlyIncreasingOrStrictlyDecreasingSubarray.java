package com.sinuke.easy;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    public int longestMonotonicSubarray(int[] nums) {
        int cntIncrease = 1, cntDecrease = 1, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) cntIncrease++;
            else if (i < nums.length - 1) {
                max = Math.max(max, cntIncrease);
                cntIncrease = 1;
            }

            if (i > 0 && nums[i] < nums[i - 1]) cntDecrease++;
            else if (i > 0) {
                max = Math.max(max, cntDecrease);
                cntDecrease = 1;
            }
        }

        return Math.max(max, Math.max(cntIncrease, cntDecrease));
    }

}
