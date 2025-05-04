package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class NumberOfEquivalentDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int[] domino : dominoes) {
            int min = Math.min(domino[0], domino[1]);
            String key = String.valueOf(min) + (domino[0] + domino[1] - min);
            int value = map.getOrDefault(key, 0);
            count += value;
            map.put(key, value + 1);
        }

        return count;
    }

}
