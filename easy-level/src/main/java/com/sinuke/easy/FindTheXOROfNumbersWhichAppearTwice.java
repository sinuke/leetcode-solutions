package com.sinuke.easy;

public class FindTheXOROfNumbersWhichAppearTwice {

    public int duplicateNumbersXOR(int[] nums) {
        int[] counts = new int[51];
        int result = 0;

        for (int num : nums) {
            counts[num]++;
            if (counts[num] == 2) result ^= num;
        }

        return result;
    }

}
