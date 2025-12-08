package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class SubstringsOfSizeThreeWithDistinctCharacters {

    public int countGoodSubstrings(String s) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i >= 3) {
                char p = s.charAt(i - 3);
                if (map.get(p) > 1) map.put(p, map.get(p) - 1);
                else map.remove(p);

            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() == 3) count++;
        }
        return count;
    }

}
