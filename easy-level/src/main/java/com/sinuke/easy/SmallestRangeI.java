package com.sinuke.easy;

public class SmallestRangeI {

    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        max = max - k;
        min = min + k;

        return Math.max(max - min, 0);
    }

}
