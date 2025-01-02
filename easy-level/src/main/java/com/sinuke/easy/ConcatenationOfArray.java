package com.sinuke.easy;

public class ConcatenationOfArray {

    // 1 ms - 96.48%
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }

        return result;
    }

    // 0 ms - 100%
    public int[] getConcatenation2(int[] nums) {
        int[] result = new int[nums.length * 2];

        System.arraycopy(nums, 0, result, 0, nums.length);
        System.arraycopy(nums, 0, result, nums.length, nums.length);

        return result;
    }

}
