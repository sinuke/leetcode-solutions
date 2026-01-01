package com.sinuke.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(nums.length);
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        List<Integer> list = freq.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue(Comparator.comparingInt(v -> v)).thenComparing(Map.Entry.comparingByKey((k1, k2) -> k2 - k1)))
                .map(Map.Entry::getKey)
                .toList();

        int i = 0;
        for (int num : list) {
            for (int j = i; j < i + freq.get(num); j++) nums[j] = num;
            i += freq.get(num);
        }

        return nums;
    }

}
