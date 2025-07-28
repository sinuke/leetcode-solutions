package com.sinuke.easy;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int n = nums.length, total = 0;

        int[] sums = new int[nums.length];
        for (int i = 0; i < n; i++) {
            sums[i] = total;
            total += nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (sums[i] == total - nums[i] - sums[i]) return i;
        }

        return -1;
    }

}
