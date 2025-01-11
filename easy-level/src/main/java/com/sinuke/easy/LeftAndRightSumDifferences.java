package com.sinuke.easy;

public class LeftAndRightSumDifferences {

    public int[] leftRightDifference(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            nums[i] = total;
        }

        int[] result = new int[nums.length];
        result[0] = Math.abs(total - nums[0]);
        result[nums.length - 1] = nums.length == 1 ? 0 : nums[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = Math.abs(total - nums[i] - nums[i - 1]);
        }

        return result;
    }

}
