package com.sinuke.easy;

import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, banned);
        Map<String, Integer> map = new HashMap<>();
        int start = -1, max = 0;
        String answer = null;
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (Character.isLetter(c)) {
                if (start == -1 || !Character.isLetter(paragraph.charAt(i - 1))) start = i;
            } else if (start != -1) {
                String word = paragraph.substring(start, i).toLowerCase();
                if (!set.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    if (map.get(word) > max) {
                        max = map.get(word);
                        answer = word;
                    }
                }
                start = -1;
            }
        }

        if (start != -1) {
            String word = paragraph.substring(start).toLowerCase();
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (map.get(word) > max) answer = word;
            }
        }

        return answer;
    }

}
