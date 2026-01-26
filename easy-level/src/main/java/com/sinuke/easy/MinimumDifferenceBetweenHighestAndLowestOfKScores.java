package com.sinuke.easy;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            int score = nums[i] - nums[i - k + 1];
            min = Math.min(min, score);
        }
        return min;
    }

}
