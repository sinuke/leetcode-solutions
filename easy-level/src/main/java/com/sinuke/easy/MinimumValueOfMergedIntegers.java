package com.sinuke.easy;

public class MinimumValueOfMergedIntegers {

    public int minMergedInteger(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i += 2) {
            min = Math.min(min, merge(nums[i - 1], nums[i]));
        }
        return min;
    }

    private int merge(int n1, int n2) {
        return Integer.parseInt(n1 + String.valueOf(n2));
    }

}
