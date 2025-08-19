package com.sinuke.medium;

public class NumberOfZeroFilledSubarrays {

    public long zeroFilledSubarray(int[] nums) {
        long sum = 0, count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
                sum += count;
            } else count = 0;
        }
        return sum;
    }

}
