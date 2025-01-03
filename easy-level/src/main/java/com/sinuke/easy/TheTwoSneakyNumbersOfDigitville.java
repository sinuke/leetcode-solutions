package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class TheTwoSneakyNumbersOfDigitville {

    // 1 ms
    public int[] getSneakyNumbers(int[] nums) {
        int[] counts = new int[100];
        int[] result = new int[2];
        int count = 0;

        for (var num : nums) {
            counts[num]++;

            if (counts[num] == 2) {
                result[count] = num;
                count++;
            }

            if (count == 2) break;
        }

        return result;
    }

    // 9 ms
    public int[] getSneakyNumbers2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

}
