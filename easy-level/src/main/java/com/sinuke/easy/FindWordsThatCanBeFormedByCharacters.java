package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>(chars.length());
        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int sum = 0;
        for (String word : words) {
            if (isGood(word, map)) sum += word.length();
        }

        return sum;
    }

    private boolean isGood(String word, Map<Character, Integer> map) {
        Map<Character, Integer> freq = new HashMap<>(word.length());
        for (char c : word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if (!map.containsKey(c) || map.get(c) < freq.get(c)) return false;
        }
        return true;
    }

}
