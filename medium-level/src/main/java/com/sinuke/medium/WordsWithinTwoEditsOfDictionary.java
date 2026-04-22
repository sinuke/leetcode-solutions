package com.sinuke.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordsWithinTwoEditsOfDictionary {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        Set<String> set = new HashSet<>(dictionary.length);
        for (String dict : dictionary) set.add(dict);

        List<String> result = new ArrayList<>(queries.length);
        for (String word : queries) {
            if (check(set, word).equals(word)) result.add(word);
        }
        return result;
    }

    private String check(Set<String> set, String word) {
        if (set.contains(word)) return word;
        for (String dict : set) {
            int diff = 0;
            for (int i = 0; i < dict.length(); i++) {
                if (dict.charAt(i) != word.charAt(i)) diff++;
                if (diff > 2) break;
            }
            if (diff <= 2) return word;
        }
        return "";
    }

}
