package com.sinuke.easy;

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {

    public int minimumOperations(int[] nums) {
        int count = 0;

        for (int num : nums) {
            count += Math.min(num % 3, 3 - num % 3);
        }

        return count;
    }

}
