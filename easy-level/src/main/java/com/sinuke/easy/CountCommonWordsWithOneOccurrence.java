package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class CountCommonWordsWithOneOccurrence {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Counts> map = new HashMap<>();
        for (var word : words1) {
            if (map.containsKey(word)) map.replace(word, map.get(word).incFirst());
            else map.put(word, new Counts().incFirst());
        }

        for (var word : words2) {
            if (map.containsKey(word)) map.replace(word, map.get(word).incSecond());
            else map.put(word, new Counts().incSecond());
        }

        int count = 0;
        for (var e : map.entrySet()) {
            if (e.getValue().isOnes()) count++;
        }
        return count;
    }

    private static class Counts {
        int first;
        int second;

        Counts incFirst() {
            this.first += 1;
            return this;
        }

        Counts incSecond() {
            this.second += 1;
            return this;
        }

        boolean isOnes() {
            return this.first == 1 && this.second == 1;
        }

    }

}
