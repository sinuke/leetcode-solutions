package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class RearrangeSpacesBetweenWords {

    public String reorderSpaces(String text) {
        List<String> words = new ArrayList<>();
        int cnt = 0, start = -1;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                cnt++;
                if (start != -1) {
                    words.add(text.substring(start, i));
                    start = -1;
                }
            } else if (start == -1) start = i;
        }
        if (start != -1) words.add(text.substring(start));

        String spaces = String.valueOf(' ').repeat(words.size() == 1 ? 0 : cnt / (words.size() - 1));
        String extra = String.valueOf(' ').repeat(words.size() == 1 ? cnt : cnt % (words.size() - 1));

        var sb = new StringBuilder(words.getFirst());
        for (int i = 1; i < words.size(); i++) {
            sb.append(spaces).append(words.get(i));
        }

        return sb.append(extra).toString();
    }

}
