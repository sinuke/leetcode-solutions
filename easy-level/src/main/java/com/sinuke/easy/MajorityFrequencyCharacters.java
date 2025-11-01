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

        for (char c : s.toCharArray()) {
            if (freq.containsKey(c)) {
                groups.get(freq.get(c)).remove(c);
                freq.replace(c, freq.get(c) + 1);
            } else freq.put(c, 1);

            groups.putIfAbsent(freq.get(c), new HashSet<>());
            groups.get(freq.get(c)).add(c);
        }

        int f = 0;
        Set<Character> result = new HashSet<>();
        for (var entry : groups.entrySet()) {
            if ((entry.getValue().size() == result.size() && entry.getKey() > f) || entry.getValue().size() > result.size()) {
                result = entry.getValue();
                f = entry.getKey();
            }
        }

        return result.stream().map(String::valueOf).collect(Collectors.joining());
    }

}
