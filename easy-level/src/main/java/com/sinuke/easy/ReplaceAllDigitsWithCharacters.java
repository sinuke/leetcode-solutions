package com.sinuke.easy;

public class ReplaceAllDigitsWithCharacters {

    public String replaceDigits(String s) {
        int i = 0;
        var sb = new StringBuilder();

        while (i < s.length()) {
            sb.append(s.charAt(i));
            if (i < s.length() - 1) sb.append(shift(s.charAt(i), s.charAt(i + 1) - '0'));
            i += 2;
        }

        return sb.toString();
    }

    private char shift(char c, int x) {
        return (char) (c + x);
    }

}
