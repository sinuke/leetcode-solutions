package com.sinuke.easy;

public class SplitTheArray {

    public boolean isPossibleToSplit(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
            if (freq[num] > 2) return false;
        }
        return true;
    }

}
