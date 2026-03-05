package com.sinuke.easy;

public class TrimTrailingVowels {

    public String trimTrailingVowels(String s) {
        var sb = new StringBuilder(s);
        while (!sb.isEmpty() && isVowel(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
