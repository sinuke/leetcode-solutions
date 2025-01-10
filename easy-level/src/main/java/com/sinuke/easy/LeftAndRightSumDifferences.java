package com.sinuke.easy;

public class LeftAndRightSumDifferences {

    public int[] leftRightDifference(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            nums[i] = total;
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) result[i] = Math.abs(total - nums[i]);
            else if (i == nums.length - 1) result[i] = nums[i - 1];
            else result[i] = Math.abs(total - nums[i] - nums[i - 1]);
        }

        return result;
    }

}
