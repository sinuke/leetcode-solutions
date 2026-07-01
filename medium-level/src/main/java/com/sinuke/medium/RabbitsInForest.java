package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        int result = 0;
        for (var entry : map.entrySet()) {
            int g = entry.getKey() + 1;
            result += (entry.getValue() % g == 0 ? entry.getValue() / g : entry.getValue() / g + 1) * g;
        }
        return result;
    }

}
