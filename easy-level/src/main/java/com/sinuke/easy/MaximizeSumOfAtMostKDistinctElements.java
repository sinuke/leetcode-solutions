package com.sinuke.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximizeSumOfAtMostKDistinctElements {

    public int[] maxKDistinct(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) set.add(num);

        List<Integer> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());

        k = Math.min(k, list.size());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = list.get(i);
        return result;
    }

}
