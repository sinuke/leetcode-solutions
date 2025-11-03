package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class SmallestAbsentPositiveGreaterThanAverage {

    public int smallestAbsent(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            set.add(num);
        }

        int target = sum / nums.length;
        target = Math.max(target, 0);
        do {
            target++;
        } while (set.contains(target));

        return target;
    }

}
