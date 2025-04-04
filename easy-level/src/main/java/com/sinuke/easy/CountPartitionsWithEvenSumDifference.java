package com.sinuke.easy;

public class CountPartitionsWithEvenSumDifference {

    public int countPartitions(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[nums.length - 1] - nums[i] - nums[i]) % 2 == 0) count++;
        }

        return count;
    }

}
