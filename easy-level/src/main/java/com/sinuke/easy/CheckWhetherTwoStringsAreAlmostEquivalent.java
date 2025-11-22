package com.sinuke.easy;

public class CheckWhetherTwoStringsAreAlmostEquivalent {

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (char c : word1.toCharArray()) f1[c - 'a']++;
        for (char c : word2.toCharArray()) f2[c - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (Math.abs(f1[i] - f2[i]) > 3) return false;
        }

        return true;
    }

}
