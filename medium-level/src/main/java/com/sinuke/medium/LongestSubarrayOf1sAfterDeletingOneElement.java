package com.sinuke.medium;

public class LongestSubarrayOf1sAfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int max = 0, j = 0, zeros = 0;
        int[] ones = new int[2];
        for (int num : nums) {
            if (num == 1) {
                ones[j]++;
                zeros = 0;
            } else {
                zeros++;
                max = Math.max(max, ones[0] + ones[1]);
                j ^= 1;
                ones[j] = 0;
            }
        }
        max = Math.max(max, ones[0] + ones[1]);
        return max == nums.length ? max - 1 : max;
    }

}
