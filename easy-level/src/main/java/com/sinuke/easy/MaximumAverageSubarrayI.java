package com.sinuke.easy;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        long sum = 0, max = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                sum += nums[i];
                max = sum;
            } else {
                sum = sum - nums[i - k] + nums[i];
                max = Math.max(max, sum);
            }
        }

        return max / (double) k;
    }

}
