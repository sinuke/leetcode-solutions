package com.sinuke.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        Map<Character, Integer[]> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) map.get(s.charAt(i))[1]++;
            else map.put(s.charAt(i), new Integer[]{i, 1});
        }

        return map.entrySet().stream()
                .filter(es -> es.getValue()[1] == 1)
                .min(Comparator.comparing(es -> es.getValue()[0]))
                .orElse(Map.entry('a', new Integer[]{-1, 0}))
                .getValue()[0];
    }

}
