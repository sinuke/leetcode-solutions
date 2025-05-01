package com.sinuke.easy;

public class MaximumProductOfTwoElementsInArray {

    public int maxProduct(int[] nums) {
        int i = -1, j = -1;
        for (int k = 0; k < nums.length; k++) {
            if (i == -1 || nums[k] >= nums[i]) i = k;
        }

        for (int k = 0; k < nums.length; k++) {
            if (j == -1 && i != k) j = k;
            else if (j != -1 && nums[k] > nums[j] && i != k) j = k;
        }

        return (nums[i] - 1) * (nums[j] - 1);
    }

}
