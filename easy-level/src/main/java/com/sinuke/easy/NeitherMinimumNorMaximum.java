package com.sinuke.easy;

public class NeitherMinimumNorMaximum {

    public int findNonMinOrMax(int[] nums) {
        if (nums.length <= 2) return -1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (max < num) max = num;
            if (min > num) min = num;
        }

        for (int num : nums) {
            if (num != max && num != min) return num;
        }

        return -1;
    }

}
