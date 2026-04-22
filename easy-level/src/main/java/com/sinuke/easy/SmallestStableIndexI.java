package com.sinuke.easy;

public class SmallestStableIndexI {

    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n], min = new int[n];
        max[0] = nums[0];
        min[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(nums[i], max[i - 1]);
            min[n - 1 - i] = Math.min(nums[n - 1 - i], min[n - i]);
        }

        for (int i = 0; i < n; i++) {
            if (max[i] - min[i] <= k) return i;
        }

        return -1;
    }

}
