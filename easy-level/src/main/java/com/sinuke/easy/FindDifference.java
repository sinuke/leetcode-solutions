package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class FindDifference {

    // fast - 2 ms
    public char findTheDifference(String s, String t) {
        int[][] map = new int[26][2];

        for (var c : s.toCharArray()) map[c - 'a'][1]++;

        for (var c : t.toCharArray())
            if (map[c - 'a'][1] == 0) return c;
            else map[c - 'a'][1]--;

        return 'a';
    }

    // slow - 11 ms
    public char findTheDifference2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>(s.length());

        for (var c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (var c : t.toCharArray())
            if (map.getOrDefault(c, 0) == 0) return c;
            else map.put(c, map.getOrDefault(c, 1) - 1);

        return 'a';
    }

}
