package com.sinuke.easy;

import java.util.Set;

public class ValidWord {

    private static final Set<Character> vowels = Set.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');

    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        int vowelsCount = 0, consonantsCount = 0;

        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isLetter(c)) return false;
            else if (Character.isLetter(c) && vowels.contains(c)) vowelsCount++;
            else if (Character.isLetter(c) && !vowels.contains(c)) consonantsCount++;
        }

        return consonantsCount >= 1 && vowelsCount >= 1;
    }

}
