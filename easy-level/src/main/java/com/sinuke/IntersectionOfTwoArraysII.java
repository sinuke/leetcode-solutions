package com.sinuke;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (var num : nums1) map.put(num, 1);
        for (var num : nums2) map.put(num, map.getOrDefault(num, 0) + 1);

        return map.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .flatMapToInt(e -> {
                    int[] result = new int[e.getValue() - 1];
                    Arrays.fill(result, e.getKey());
                    return Arrays.stream(result);
                })
                .sorted()
                .toArray();
    }

}
