package com.sinuke.easy;

public class MinMaxGame {

    public int minMaxGame(int[] nums) {
        while (nums.length > 1) {
            int[] nn = new int[nums.length / 2];
            for (int i = 0; i < nn.length; i++) {
                if (i % 2 == 0) nn[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                else nn[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
            nums = nn;
        }

        return nums[0];
    }

}
