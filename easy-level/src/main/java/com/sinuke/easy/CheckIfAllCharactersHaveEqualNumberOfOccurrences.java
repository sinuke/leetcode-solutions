package com.sinuke.easy;

public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {

    public boolean areOccurrencesEqual(String s) {
        int[] occurrences = new int[26];
        for (char c : s.toCharArray()) {
            occurrences[c - 'a']++;
        }

        int value = 0;
        for (int i = 0; i < 26; i++) {
            if (value == 0 && occurrences[i] != 0) value = occurrences[i];
            if (occurrences[i] != 0 && occurrences[i] != value) return false;
        }

        return true;
    }

}
