package com.sinuke.medium;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] counts = new int[26];

        for (var word : words2) {
            int[] temp = counter(word);
            for (int i = 0; i < 26; i++) {
                counts[i] = Math.max(counts[i], temp[i]);
            }
        }

        List<String> result = new ArrayList<>();

        for (var word : words1) {
            if (isUniversal(counter(word), counts)) result.add(word);
        }

        return result;
    }

    private int[] counter(String word) {
        int[] count = new int[26];
        for (char ch : word.toCharArray()) {
            ++count[ch - 'a'];
        }
        return count;
    }

    private boolean isUniversal(int[] countsA, int[] countsB) {
        for (int i = 0; i < 26; i++) {
            if (countsA[i] < countsB[i]) return false;
        }
        return true;
    }

}
