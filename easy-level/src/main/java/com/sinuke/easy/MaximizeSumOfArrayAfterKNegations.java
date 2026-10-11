package com.sinuke.easy;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        int sum = 0, smallest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (k > 0 && nums[i] < 0) {
                nums[i] = Math.abs(nums[i]);
                k--;
            }

            sum += nums[i];
            smallest = Math.min(smallest, Math.abs(nums[i]));
        }

        if (k > 0 && k % 2 != 0) sum -= 2 * smallest;

        return sum;
    }

}
