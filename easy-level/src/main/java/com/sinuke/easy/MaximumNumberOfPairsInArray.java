package com.sinuke.easy;

public class MaximumNumberOfPairsInArray {

    public int[] numberOfPairs(int[] nums) {
        int[] freq = new int[101];
        int leftover = nums.length, count = 0;
        for (int num : nums) {
            freq[num]++;
            if (freq[num] == 2) {
                count++;
                leftover -= 2;
                freq[num] -= 2;
            }
        }
        return new int[] {count, leftover};
    }

}
