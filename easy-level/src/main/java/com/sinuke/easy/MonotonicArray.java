package com.sinuke.easy;

public class MonotonicArray {

    public boolean isMonotonic(int[] nums) {
        int orient = 0, prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev) {
                if (orient < 0) return false;
                if (orient == 0) orient = 1;
            } else if (nums[i] < prev) {
                if (orient > 0) return false;
                if (orient == 0) orient = -1;
            }
            prev = nums[i];
        }

        return true;
    }

}
