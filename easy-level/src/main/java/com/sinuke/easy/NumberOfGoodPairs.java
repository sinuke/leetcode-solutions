package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {

    // 0 ms
    public int numIdenticalPairs(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) {
            counts[num]++;
        }

        int result = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > 1) result += counts[i] * (counts[i] - 1) / 2;
        }

        return result;
    }

    // 2 ms
    public int numIdenticalPairs2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.values().stream()
                .filter(v -> v > 1)
                .mapToInt(v -> v * (v - 1) / 2)
                .sum();
    }

}
