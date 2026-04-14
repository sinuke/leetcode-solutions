package com.sinuke.easy;

public class MinimumAbsoluteDifferenceBetweenTwoValues {

    public int minAbsoluteDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] == 1 && nums[j] == 2) || (nums[j] == 1 && nums[i] == 2)) {
                    min = Math.min(min, Math.abs(i - j));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
