package com.sinuke.easy;

public class MaximumNumberOfOperationsWithTheSameScoreI {

    public int maxOperations(int[] nums) {
        int score = nums[0] + nums[1], count = 1, i = 2;
        while (i < nums.length - 1) {
            int current = nums[i] + nums[i + 1];
            if (current != score) break;
            i += 2;
            count++;
        }
        return count;
    }

}
