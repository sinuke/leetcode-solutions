package com.sinuke.easy;

public class MaximumValueOfOrderedTripletI {

    public long maximumTripletValue(int[] nums) {
        long max = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k ++) {
                    long val = (long) (nums[i] - nums[j]) * nums[k];
                    if (val > max) max = val;
                }
            }
        }
        return max;
    }

}
