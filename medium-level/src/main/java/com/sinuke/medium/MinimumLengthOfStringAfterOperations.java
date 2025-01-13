package com.sinuke.medium;

public class MinimumLengthOfStringAfterOperations {

    public int minimumLength(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        int result = 0;

        for (int i = 0; i < 26; i++) {
            if (counts[i] >= 3) {
                while (counts[i] >= 3) {
                    counts[i] -= 2;
                }
            }

            result += counts[i];
        }

        return result;
    }

}
