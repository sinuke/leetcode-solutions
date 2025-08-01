package com.sinuke.easy;

public class SmallestIndexWithDigitSumEqualToIndex {

    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == digitSum(nums[i])) return i;
        }
        return -1;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
