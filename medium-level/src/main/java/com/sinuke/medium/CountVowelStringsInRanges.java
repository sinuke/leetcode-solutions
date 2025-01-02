package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    // 9 ms
    public int[] vowelStrings2(String[] words, int[][] queries) {
        int[] counts = new int[words.length + 1];
        Set<Character> vowels = Set.of('a', 'i', 'e', 'o', 'u');
        for (int i = 0; i < words.length; i++) {
            counts[i + 1] = counts[i];
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) counts[i + 1]++;
        }

        var results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            var query = queries[i];
            if (query[0] == 0) results[i] = counts[query[1] + 1];
            else results[i] = counts[query[1] + 1] - counts[query[0]];
        }
        return results;
    }

}
