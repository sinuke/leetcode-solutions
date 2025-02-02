package com.sinuke.easy;

public class DifferenceBetweenElementSumAndDigitSumOfArray {

    public int differenceOfSum(int[] nums) {
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];

            while (nums[i] > 0) {
                sum2 += nums[i] % 10;
                nums[i] /= 10;
            }

        }

        return Math.abs(sum1 - sum2);
    }

}
