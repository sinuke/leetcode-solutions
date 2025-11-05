package com.sinuke.easy;

public class MinimumOperationsToEqualizeArray {

    public int minOperations(int[] nums) {
        int first = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != first) return 1;
        }
        return 0;
    }

}
