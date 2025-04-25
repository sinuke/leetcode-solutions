package com.sinuke.easy;

public class TransformArrayByParity {

    public int[] transformArray(int[] nums) {
        int[] result = new int[nums.length];
        int i = nums.length - 1;
        for (int num : nums) {
            if (num % 2 != 0) result[i--] = 1;
        }
        return result;
    }

}
