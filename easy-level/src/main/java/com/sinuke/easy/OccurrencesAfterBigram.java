package com.sinuke.easy;

import java.util.Arrays;

public class OccurrencesAfterBigram {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        String[] result = new String[words.length];
        int i = 0, w = 0;
        while (i < words.length - 2) {
            if (first.equals(words[i]) && second.equals(words[i + 1])) {
                result[w++] = words[i + 2];
                i++;
            }
            i++;
        }
        return Arrays.copyOf(result, w);
    }

}
