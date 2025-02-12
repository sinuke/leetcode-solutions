package com.sinuke.easy;

import java.util.Arrays;

public class MinimumNumberGame {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int i = 0;

        while (i < nums.length - 1) {
            int tmp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = tmp;

            i += 2;
        }

        return nums;
    }

}
