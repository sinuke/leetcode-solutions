package com.sinuke.easy;

public class MinimumDistanceToTargetElement {

    public int getMinDistance(int[] nums, int target, int start) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result = (result == -1) ? Math.abs(i - start) : Math.min(result, Math.abs(i - start));
            }
        }
        return result;
    }

}
