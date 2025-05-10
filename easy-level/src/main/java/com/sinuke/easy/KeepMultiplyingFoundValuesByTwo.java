package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingFoundValuesByTwo {

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }

}
