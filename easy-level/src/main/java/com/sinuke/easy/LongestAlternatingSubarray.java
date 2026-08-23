package com.sinuke.easy;

public class LongestAlternatingSubarray {

    public int alternatingSubarray(int[] nums) {
        int max = 0, diff = 1, start = 0, i = 1;
        while (i < nums.length) {
            if (nums[i] - nums[i - 1] == diff) {
                diff *= -1;
            } else {
                max = Math.max(max, i - start);
                if (nums[i] - nums[i - 1] == 1) {
                    diff = -1;
                    start = i - 1;
                } else {
                    diff = 1;
                    start = i;
                }
            }

            i++;
        }

        max = Math.max(max, i - start);
        return max <= 1 ? -1 : max;
    }

}
