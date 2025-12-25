package com.sinuke.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumNumberOfPushesToTypeWordII {

    public int minimumPushes(String word) {
        Map<Character, Integer> freq = new HashMap<>(26);
        for (char c : word.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

        List<Character> chars = freq.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((v1, v2) -> v2 - v1))
                .map(Map.Entry::getKey)
                .toList();

        int cnt = 0;
        for (int i = 0; i < chars.size(); i++) {
            char c = chars.get(i);
            int m = i < 8 ? 1 : i < 16 ? 2 : i < 24 ? 3 : 4;
            cnt += freq.get(c) * m;
        }

        return cnt;
    }

}
