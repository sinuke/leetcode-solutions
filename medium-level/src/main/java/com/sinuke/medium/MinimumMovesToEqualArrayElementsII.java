package com.sinuke.medium;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        if (nums.length % 2 == 0) median = (median + nums[nums.length / 2 - 1]) / 2;

        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(num - median);
        }
        return sum;
    }

}
