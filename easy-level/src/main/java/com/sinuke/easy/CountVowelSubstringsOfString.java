package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class CountVowelSubstringsOfString {

    public int countVowelSubstrings(String word) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < word.length() - 1; i++) {
            char c = word.charAt(i);

            if (isVowel(c)) {
                int j = i + 1;
                set.clear();
                set.add(c);
                while (j < word.length() && isVowel(word.charAt(j))) {
                    set.add(word.charAt(j++));
                    count += (set.size() == 5) ? 1 : 0;
                }
            } else set.clear();
        }
        return count;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
