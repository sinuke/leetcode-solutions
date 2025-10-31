package com.sinuke.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MajorityFrequencyCharacters {

    public String majorityFrequencyGroup(String s) {
        Map<Character, Integer> freq = new HashMap<>(s.length());
        Map<Integer, Set<Character>> groups = new HashMap<>();
        Set<Character> result = new HashSet<>();
        int f = 0;
        for (char c : s.toCharArray()) {
            if (freq.containsKey(c)) {
                groups.get(freq.get(c)).remove(c);
                freq.replace(c, freq.get(c) + 1);
            } else freq.put(c, 1);

            groups.putIfAbsent(freq.get(c), new HashSet<>());
            groups.get(freq.get(c)).add(c);

            if (groups.get(freq.get(c)).size() >= result.size() && freq.get(c) > f) {
                result = groups.get(freq.get(c));
                f = freq.get(c);
            }
        }

        return result.stream().map(String::valueOf).collect(Collectors.joining());
    }

}
