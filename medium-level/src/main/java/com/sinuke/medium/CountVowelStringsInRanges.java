package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;

public class CountVowelStringsInRanges {

    // 16 ms
    public int[] vowelStrings(String[] words, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) count++;
            map.put(i, count);
        }

        var results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            var query = queries[i];
            if (query[0] == 0) results[i] = map.get(query[1]);
            else results[i] = map.get(query[1]) - map.getOrDefault(query[0] - 1, 0);
        }
        return results;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
