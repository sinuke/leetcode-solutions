package com.sinuke;

import java.util.Set;

public class ReverseVowelsOfString {

    private final static Set<Character> vowels = Set.of(
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'
    );

    public String reverseVowels(String s) {

        int left = 0, right = s.length() - 1;

        char[] chars = new char[s.length()];

        while (left < right) {
            if (isVowel(s.charAt(left)) && !isVowel(s.charAt(right))) {
                chars[right] = s.charAt(right);
                right--;
            }
            else if (!isVowel(s.charAt(left)) && isVowel(s.charAt(right))) {
                chars[left] = s.charAt(left);
                left++;
            }
            else if (isVowel(s.charAt(left)) && isVowel(s.charAt(right))) {
                chars[right] = s.charAt(left);
                chars[left] = s.charAt(right);
                left++;
                right--;
            } else {
                chars[right] = s.charAt(right);
                chars[left] = s.charAt(left);
                left++;
                right--;
            }
        }

        if (left == right) chars[left] = s.charAt(right);
        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        return vowels.contains(c);
    }

}
