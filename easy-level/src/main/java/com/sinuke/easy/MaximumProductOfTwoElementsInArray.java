package com.sinuke.easy;

public class MaximumProductOfTwoElementsInArray {

    public int maxProduct(int[] nums) {
        int i = 0, j = -1;
        for (int k = 1; k < nums.length; k++) {
            if (nums[k] >= nums[i]) {
                if (j == -1 || nums[i] > nums[j]) j = i;
                i = k;
            }
        }

        return (nums[i] - 1) * (nums[j] - 1);
    }

}
