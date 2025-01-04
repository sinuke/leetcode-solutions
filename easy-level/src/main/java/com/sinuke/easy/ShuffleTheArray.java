package com.sinuke.easy;

public class ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        var result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i < n) result[i * 2] = nums[i];
            else result[(i - n) * 2 + 1] = nums[i];
        }

        return result;
    }

}
