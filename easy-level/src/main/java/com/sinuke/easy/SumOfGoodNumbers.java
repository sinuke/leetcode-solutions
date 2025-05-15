package com.sinuke.easy;

public class SumOfGoodNumbers {

    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += isGoodNumber(nums, i, k) ? nums[i] : 0;
        }
        return sum;
    }

    private boolean isGoodNumber(int[] nums, int i, int k) {
        boolean leftCondition = (i - k < 0) || (nums[i] > nums[i - k]);
        boolean rightCondition = (i + k >= nums.length) || (nums[i] > nums[i + k]);
        return leftCondition && rightCondition;
    }

}
