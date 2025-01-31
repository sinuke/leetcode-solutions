package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class NumberOfArithmeticTriplets {

    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) count++;
                }
            }
        }

        return count;
    }

    // solution from LeetCode
    public int arithmeticTriplets2(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int count = 0;
        for (int num : nums) {
            if (set.contains(num + diff) && set.contains(num + diff + diff)) count++;
        }

        return count;
    }

}
