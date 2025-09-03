package com.sinuke.medium;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 1;

        int zeros = nums[left] == 0 ? 1 : 0;
        int max = Math.max(0, Math.min(k, zeros));

        while (right < nums.length) {
            if (nums[right] == 0) zeros++;

            while (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

}
