package com.sinuke.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringMatchingInArray {

    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length - 1; i++) {
            var word = words[i];

            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(word)) {
                    result.add(word);
                    break;
                }
            }
        }

        return result;
    }

}
