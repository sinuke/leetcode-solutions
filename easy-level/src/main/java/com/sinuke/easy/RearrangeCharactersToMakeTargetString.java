package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class RearrangeCharactersToMakeTargetString {

    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : target.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int min = Integer.MAX_VALUE;
        for (var e : map.entrySet()) min = Math.min(min, freq[e.getKey() - 'a'] / e.getValue());
        return min;
    }

}
