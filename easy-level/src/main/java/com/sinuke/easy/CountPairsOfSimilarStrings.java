package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class CountPairsOfSimilarStrings {

    public int similarPairs(String[] words) {
        Set<Character>[] dp = new HashSet[words.length];
        for (int i = 0; i < words.length; i++) {
            dp[i] = getSetOfChars(words[i]);
        }

        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (dp[i].equals(dp[j])) count++;
            }
        }
        return count;
    }

    private Set<Character> getSetOfChars(String word) {
        Set<Character> set = new HashSet<>(word.length());
        for (char c : word.toCharArray()) set.add(c);
        return set;
    }

}
