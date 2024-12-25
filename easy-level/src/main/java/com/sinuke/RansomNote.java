package com.sinuke;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> letters = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            letters.put(c, letters.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (letters.containsKey(c)) {
                if (letters.get(c) == 1) letters.remove(c);
                else letters.put(c, letters.get(c) - 1);
            } else return false;
        }

        return true;
    }

    public boolean canConstructFromLeetcode(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] counts = new int[26];
        for (char c : magazine.toCharArray()) {
            counts[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (counts[c - 'a'] == 0) return false;
            counts[c - 'a']--;
        }

        return true;
    }

}
