package com.sinuke.easy;

public class MaximumDifferenceBetweenIncreasingElements {

    public int maximumDifference(int[] nums) {
        int min = nums[0], max = nums[1], result = max - min;

        for (int i = 1; i < nums.length - 1; i++) {
            if (min > nums[i]) {
                min = nums[i];
                max = nums[i + 1];
            }

            if (max < nums[i + 1]) max = nums[i + 1];
            if (max - min > result) result = max - min;
        }

        return result > 0 ? result : -1;
    }

}
