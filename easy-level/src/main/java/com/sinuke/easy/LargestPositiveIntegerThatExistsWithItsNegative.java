package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class LargestPositiveIntegerThatExistsWithItsNegative {

    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < 0) set.add(num);
        }

        int result = -1;
        for (int num : nums) {
            if (num > result && set.contains(- num)) result = num;
        }

        return result;
    }

}
