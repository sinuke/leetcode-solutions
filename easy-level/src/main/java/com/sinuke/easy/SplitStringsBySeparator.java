package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class SplitStringsBySeparator {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (var wrds : words) {
            result.addAll(split(wrds, separator));
        }
        return result;
    }

    private List<String> split(String str, char separator) {
        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == separator || i == str.length() - 1) {
                int end = i == str.length() - 1 && c != separator ? i + 1 : i;
                var word = str.substring(start, end);
                start = i + 1;
                if (!word.isEmpty()) result.add(word);
            };
        }
        return result;
    }

}
