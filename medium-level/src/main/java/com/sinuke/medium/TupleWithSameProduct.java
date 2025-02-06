package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {

    // slow - 329 ms
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }

        return map.values().stream()
                .filter(value -> value > 2 && value % 2 == 0)
                .map(value -> value * (value - 2))
                .reduce(0, Integer::sum);
    }

}
