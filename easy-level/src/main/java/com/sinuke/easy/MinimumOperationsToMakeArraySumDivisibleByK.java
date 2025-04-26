package com.sinuke.easy;

public class MinimumOperationsToMakeArraySumDivisibleByK {

    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        return sum % k;
    }

}
