package com.sinuke.easy;

import java.util.Arrays;

public class LimitOccurrencesInSortedArray {

    public int[] limitOccurrences(int[] nums, int k) {
        int prev = nums[0], cnt = 1, j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                cnt++;
                if (cnt <= k) nums[j++] = nums[i];
            } else {
                nums[j++] = nums[i];
                cnt = 1;
            }
            prev = nums[i];
        }

        return Arrays.copyOf(nums, j);
    }

}
