package com.sinuke.easy;

public class MaximumStrongPairXORI {

    public int maximumStrongPairXor(int[] nums) {
        int max = 0;
        for (int x = 0; x < nums.length - 1; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                if (Math.abs(nums[x] - nums[y]) <= Math.min(nums[x], nums[y])) max = Math.max(max, nums[x] ^ nums[y]);
            }
        }
        return max;
    }

}
