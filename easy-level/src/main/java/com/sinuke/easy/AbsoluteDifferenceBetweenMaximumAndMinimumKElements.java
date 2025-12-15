package com.sinuke.easy;

import java.util.Arrays;

public class AbsoluteDifferenceBetweenMaximumAndMinimumKElements {

    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 0, max = 0;
        for (int i = 0; i < k; i++) {
            min += nums[i];
            max += nums[nums.length - i - 1];
        }
        return Math.abs(max - min);
    }

}
