package com.sinuke.easy;

public class BuildArrayFromPermutation {

    public int[] buildArray(int[] nums) {
        var result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }

        return result;
    }

}
