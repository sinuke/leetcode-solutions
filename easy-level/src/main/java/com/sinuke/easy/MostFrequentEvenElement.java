package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (num % 2 == 0) map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int freq = 0, value = -1;
        for (var entry : map.entrySet()) {
            if (entry.getValue() > freq) {
                value = entry.getKey();
                freq = entry.getValue();
            } else if (entry.getValue() == freq) value = Math.min(value, entry.getKey());
        }

        return value;
    }

}
