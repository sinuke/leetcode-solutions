package com.sinuke.easy;

public class LongestEvenOddSubarrayWithThreshold {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                int lng = 1, j = i + 1;
                while (j < nums.length && nums[j] <= threshold) {
                    if (nums[j] % 2 != nums[j - 1] % 2) lng++;
                    else break;
                    j++;
                }
                max = Math.max(lng, max);
            }
        }
        return max;
    }

}