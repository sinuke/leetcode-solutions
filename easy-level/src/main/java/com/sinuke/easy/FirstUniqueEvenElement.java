package com.sinuke.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueEvenElement {

    public int firstUniqueEven(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>(100);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                map.putIfAbsent(nums[i], new int[]{0, i});
                map.get(nums[i])[0]++;
            }
        }

        return map.entrySet().stream()
                .filter(e -> e.getValue()[0] == 1)
                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(v -> v[1])))
                .mapToInt(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }

}
