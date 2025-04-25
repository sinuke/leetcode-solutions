package com.sinuke.easy;

public class SumOfSquaresOfSpecialElements {

    public int sumOfSquares(int[] nums) {
        int result = 0, n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) result += nums[i - 1] * nums[i - 1];
        }
        return result;
    }

}
