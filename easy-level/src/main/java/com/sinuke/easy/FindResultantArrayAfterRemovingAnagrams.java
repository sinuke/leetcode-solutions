package com.sinuke.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindResultantArrayAfterRemovingAnagrams {

    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>(words.length);
        List<String> anagrams = new ArrayList<>(words.length);

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String anagram = new String(chars);

            if (anagrams.isEmpty() || !anagrams.getLast().equals(anagram)) {
                result.add(word);
                anagrams.add(anagram);
            }
        }

        return result;
    }

}
