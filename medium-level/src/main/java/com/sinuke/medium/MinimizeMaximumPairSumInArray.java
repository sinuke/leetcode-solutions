package com.sinuke.medium;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, sum = 0;
        while (l <= r) sum = Math.max(nums[l++] + nums[r--], sum);
        return sum;
    }

}
