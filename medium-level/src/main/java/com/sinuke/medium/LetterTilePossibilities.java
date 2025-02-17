package com.sinuke.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LetterTilePossibilities {

    private final Map<Integer, Integer> factorial = Map.of(
            1, 1,
            2, 2,
            3, 6,
            4, 24,
            5, 120,
            6, 720,
            7, 5040
    );

    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        int totalCombinations = 0;

        for (int k = 1; k <= n; k++) {
            Set<String> uniqueCombinations = new HashSet<>();
            combinations(tiles.toCharArray(), "", k, uniqueCombinations);
            for (String comb : uniqueCombinations) {
                totalCombinations += countUniquePermutations(comb);
            }
        }

        return totalCombinations;
    }

    private int countUniquePermutations(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        int numPerms = factorial.get(s.length());
        for (int count : counts.values()) {
            numPerms /= factorial.get(count);
        }
        return numPerms;
    }

    private void combinations(char[] arr, String prefix, int k, Set<String> result) {
        if (k == 0) {
            char[] sorted = prefix.toCharArray();
            Arrays.sort(sorted);
            result.add(new String(sorted));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            combinations(Arrays.copyOfRange(arr, i + 1, arr.length), prefix + arr[i], k - 1, result);
        }
    }

}
