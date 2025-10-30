package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class SumOfElementsWithFrequencyDivisibleByK {

    public int sumDivisibleByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(100);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        for (var e : map.entrySet()) {
            if (e.getValue() % k == 0) {
                sum += e.getValue() * e.getKey();
            }
        }

        return sum;
    }

}
