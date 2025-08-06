package com.sinuke.easy;

import java.util.Arrays;

public class OccurrencesAfterBigram {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        int i = 0, w = 0;
        while (i < words.length - 2) {
            if (first.equals(words[i]) && second.equals(words[i + 1])) {
                words[w++]  = words[i + 2];
            }
            i++;
        }
        return Arrays.copyOf(words, w);
    }

}
