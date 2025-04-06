package com.sinuke.easy;

import java.util.Set;

public class DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int left = 0, right = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (vowels.contains(s.charAt(i))) left++;
            if (vowels.contains(s.charAt(s.length() / 2 + i))) right++;
        }

        return left == right;
    }

}
