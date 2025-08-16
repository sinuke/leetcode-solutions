package com.sinuke.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (var word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue((v1, v2) -> v2 - v1).thenComparing(Map.Entry.comparingByKey()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
