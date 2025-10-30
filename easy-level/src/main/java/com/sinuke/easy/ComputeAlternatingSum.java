package com.sinuke.easy;

public class ComputeAlternatingSum {

    public int alternatingSum(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i] * (i % 2 == 0 ? 1 : -1);
        }
        return sum;
    }

}
