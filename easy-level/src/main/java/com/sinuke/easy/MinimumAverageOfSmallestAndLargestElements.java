package com.sinuke.easy;

import java.util.Arrays;

public class MinimumAverageOfSmallestAndLargestElements {

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);

        double min = Double.MAX_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            var average = ((double) (nums[i] + nums[nums.length - 1 - i])) / 2;
            if (average < min) min = average;
        }
        return min;
    }

}
