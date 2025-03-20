package com.sinuke.easy;

public class MaximumSumWithExactlyKElements {

    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }

        int sum = max;
        for (int i = 1; i < k; i++) {
            sum = sum + max + i;
        }

        return sum;
    }

}
