package com.sinuke.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingElements {

    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        List<Integer> result = new ArrayList<>(nums.length - 2);
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) result.add(i);
        }

        return result;
    }

}
