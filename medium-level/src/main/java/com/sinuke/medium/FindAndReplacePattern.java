package com.sinuke.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] patt = new int[pattern.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            map.putIfAbsent(pattern.charAt(i), i);
            patt[i] = map.get(pattern.charAt(i));
        }

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (match(word, patt)) result.add(word);
        }
        return result;
    }

    private boolean match(String word, int[] pattern) {
        if (pattern.length != word.length()) return false;

        int[] wordPattern = new int[word.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.putIfAbsent(word.charAt(i), i);
            wordPattern[i] = map.get(word.charAt(i));
            if (pattern[i] != wordPattern[i]) return false;
        }

        return true;
    }

}
