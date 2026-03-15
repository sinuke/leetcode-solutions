package com.sinuke.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeSimilarItems {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) map.put(item[0], item[1]);
        for (int[] item : items2) map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> List.of(e.getKey(), e.getValue()))
                .toList();
    }

}
