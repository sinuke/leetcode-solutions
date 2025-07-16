package com.sinuke.easy;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, current = 0;
        for (int num : nums) {
            if (num == 1) current++;
            else {
                max = Math.max(max, current);
                current = 0;
            }
        }
        return Math.max(max, current);
    }

}
