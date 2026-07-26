package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSubarraySumAfterDeletion {

    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        int max = - 101, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            if (num > 0 && !set.contains(num)) {
                sum += num;
                set.add(num);
            }
        }

        return max < 0 ? max : sum;
    }

}
