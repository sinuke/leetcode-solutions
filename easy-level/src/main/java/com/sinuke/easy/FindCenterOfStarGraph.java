package com.sinuke.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindCenterOfStarGraph {

    // 6 ms
    public int findCenter(int[][] edges) {
        int[] counts = new int[100001];
        int center = 0;

        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
            center = counts[edge[0]] > 1 ? edge[0] : edge[1];
        }

        return center;
    }

    // 36 ms
    public int findCenter2(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] edge : edges) {
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }

        return map.entrySet().stream()
                .filter(e -> e.getValue() == edges.length)
                .mapToInt(Map.Entry::getKey)
                .findFirst().orElse(0);
    }

    // 0 ms
    public int findCenter3(int[][] edges) {
        Set<Integer> set = new HashSet<>();

        for (int[] edge : edges) {
            if (set.contains(edge[0])) return edge[0];
            if (set.contains(edge[1])) return edge[1];

            set.add(edge[0]);
            set.add(edge[1]);
        }

        return 0;
    }

}
