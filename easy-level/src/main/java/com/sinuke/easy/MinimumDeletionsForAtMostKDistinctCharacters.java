package com.sinuke.easy;

import java.util.Arrays;

public class MinimumDeletionsForAtMostKDistinctCharacters {

    // 1 ms
    public int minDeletion(String s, int k) {
        int[] counts = new int[26];
        int[] sorted = new int[17];
        int unique = 0;
        for (char c : s.toCharArray()) {
            int indx = c - 'a';

            sorted[counts[indx]]--;
            counts[indx]++;
            if (counts[indx] == 1) unique++;
            sorted[counts[indx]]++;
        }

        if (unique <= k) return 0;

        int result = 0;
        for (int i = 1; i < sorted.length; i++) {
            while (sorted[i] > 0) {
                sorted[i]--;
                result += i;
                unique--;
                if (unique == k) return result;
            }
        }

        return result;
    }

    // 3 ms
    public int minDeletion2(String s, int k) {
        int[] counts = new int[26];
        int unique = 0;
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
            if (counts[c - 'a'] == 1) unique++;
        }
        if (unique <= k) return 0;

        Arrays.sort(counts);

        int result = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                result += counts[i];
                unique--;
                if (k == unique) return result;
            }
        }

        return result;
    }

}
