package com.sinuke.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumNumberOfPushesToTypeWordII {

    // 74 ms
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

    // 10 ms - from LeetCode
    public int minimumPushes2(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) freq[c - 'a']++;

        Integer[] sorted = new Integer[26];
        for (int i = 0; i < 26; i++) sorted[i] = freq[i];
        Arrays.sort(sorted, Comparator.reverseOrder());

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (sorted[i] == 0) break;
            cnt += sorted[i] * (i / 8 + 1);
        }

        return cnt;
    }

}
