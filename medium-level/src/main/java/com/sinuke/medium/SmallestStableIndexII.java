package com.sinuke.medium;

public class SmallestStableIndexII {

    public int smallestStableIndexII(int[] nums, int k) {
        int n = nums.length, max = nums[0], min = nums[n - 1];
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            a[i][0] = max;
            min = Math.min(min, nums[n - i - 1]);
            a[n - i - 1][1] = min;
        }

        int result = -1;
        for (int i = 0; i < n; i++) {
            if (a[i][0] - a[i][1] <= k && result == -1) result = i;
        }
        return result;
    }

}
