package com.sinuke.easy;

public class VowelConsonantScore {

    public int vowelConsonantScore(String s) {
        int v = 0, c = 0;
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) v++;
            else if (ch != ' ' && !Character.isDigit(ch)) c++;
        }
        return c == 0 ? 0 : v / c;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}
