package com.sinuke.easy;

public class RemoveOneElementToMakeArrayStrictlyIncreasing {

    public boolean canBeIncreasing(int[] nums) {
        if (nums.length == 2) return true;

        for (int i = 0; i < nums.length; i++) {
            boolean increasing = true;
            for (int j = 1; j < nums.length; j++) {
                if (i != j && i != j - 1) {
                    if (nums[j - 1] >= nums[j]) increasing = false;
                } else if (i == j - 1 && i > 0) {
                    if (nums[j - 2] >= nums[j]) increasing = false;
                }
            }
            if (increasing) return true;
        }

        return false;
    }

}
