package com.sinuke.easy;

public class DistributeElementsIntoTwoArraysI {

    public int[] resultArray(int[] nums) {
        int n = nums.length, l = 0, r = 0;
        int[] result = new int[n];
        result[l++] = nums[0];
        nums[r++] = nums[1];

        for (int i = 2; i < n; i++) {
            if (result[l - 1] > nums[r - 1]) result[l++] = nums[i];
            else nums[r++] = nums[i];
        }
        for (int i = 0; i < r; i++) result[l++] = nums[i];

        return result;
    }

}
