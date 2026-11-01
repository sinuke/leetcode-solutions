package com.sinuke.easy;

public class DifferenceBetweenPeaksAndValleys {

    public int peakValleyDifference(int[] nums) {
        int p = 0, v = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) p += nums[i];
            else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) v += nums[i];
        }
        return p - v;
    }

}
