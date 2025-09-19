package com.sinuke.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindTheMostCommonResponse {

    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> stats = new HashMap<>();
        int max = 0;
        String result = "";

        for (var day : responses) {
            Set<String> set = new HashSet<>(day.size());
            for (String response : day) {
                if (set.contains(response)) continue;
                else set.add(response);

                stats.put(response, stats.getOrDefault(response, 0) + 1);
                if (stats.get(response) > max) {
                    max = stats.get(response);
                    result = response;
                } else if (stats.get(response) == max && response.compareTo(result) < 0) result = response;
            }
        }

        return result;
    }

}
