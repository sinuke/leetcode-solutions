package com.sinuke.easy;

public class FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((num >= 10 && num < 100) || (num >= 1_000 && num < 10_000) || num == 100_000) count++;
        }
        return count;
    }

}
