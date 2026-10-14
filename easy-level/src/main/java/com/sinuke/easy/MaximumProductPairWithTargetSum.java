package com.sinuke.easy;

public class MaximumProductPairWithTargetSum {

    public int[] maxProductPair(int[] nums, int target) {
        int[] p = new int[2];
        p[0] = -1;
        p[1] = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && nums[i] > nums[j]) {
                    if ((p[0] == -1 && p[1] == -1) || nums[i] * nums[j] > nums[p[0]] * nums[p[1]]) {
                        p[0] = i;
                        p[1] = j;
                    }
                }
            }
        }
        return p;
    }

}
