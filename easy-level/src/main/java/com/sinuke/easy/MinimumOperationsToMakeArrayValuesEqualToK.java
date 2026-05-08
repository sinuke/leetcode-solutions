package com.sinuke.easy;

import java.util.Arrays;

public class MinimumOperationsToMakeArrayValuesEqualToK {

    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums[0] < k) return -1;

        int cnt = 0, i = nums.length - 1, prev = nums[i];
        while (i >= 0 && nums[i] != k) {
            if (nums[i] != prev) cnt++;
            prev = nums[i];
            i--;
        }
        if (prev != k) cnt++;

        return cnt;
    }

}
