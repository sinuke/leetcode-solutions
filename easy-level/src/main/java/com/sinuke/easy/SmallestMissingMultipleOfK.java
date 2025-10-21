package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class SmallestMissingMultipleOfK {

    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int m = k;
        while (set.contains(m)) m += k;

        return m;
    }

}
