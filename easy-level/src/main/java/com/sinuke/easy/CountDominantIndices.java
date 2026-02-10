package com.sinuke.easy;

public class CountDominantIndices {

    public int dominantIndices(int[] nums) {
        int count = 0, sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i != nums.length - 1 && nums[i] * (nums.length - i - 1) > sum) count++;
            sum += nums[i];
        }
        return count;
    }

}
