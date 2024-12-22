package com.sinuke;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        var words = s.split(" ");

        if (words.length != pattern.length()) return false;

        Map<String, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();

        var checker = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) checker.append(map.get(words[i]));
            else if (used.contains(pattern.charAt(i))) return false;
            else {
                map.put(words[i], pattern.charAt(i));
                used.add(pattern.charAt(i));
                checker.append(pattern.charAt(i));
            }
        }

        return pattern.contentEquals(checker);
    }

}
