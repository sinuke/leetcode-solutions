package com.sinuke.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctAverages {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> set = new HashSet<>(nums.length / 2);
        for (int i = 0; i < nums.length / 2; i++) {
            set.add((nums[i] + nums[nums.length - i - 1]) / 2d);
        }
        return set.size();
    }

}
