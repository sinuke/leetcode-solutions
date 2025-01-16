package com.sinuke.easy;

public class MinimumOperationsToExceedThresholdValueI {

    public int minOperations(int[] nums, int k) {
        int count = 0;

        for (int num : nums) {
            if (num < k) count++;
        }

        return count;
    }

}
