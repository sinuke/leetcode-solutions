package com.sinuke.medium;

public class ReverseWordsWithSameVowelCount {

    public String reverseWords(String s) {
        var sb = new StringBuilder();
        int cnt = 0, ws = -1, first = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' || i == s.length() - 1) {
                if (isVowel(c)) cnt++;
                if (ws == -1) ws = i;

                int end = i == s.length() - 1 ? i + 1 : i;
                if (first == -1) {
                    first = cnt;
                    sb.append(s, 0, end);
                } else if (cnt == first) {
                    for (int j = i == s.length() - 1 ? i : i - 1; j >= ws; j--) sb.append(s.charAt(j));
                } else sb.append(s, ws, end);

                if (i != s.length() - 1) sb.append(' ');

                ws = -1;
                cnt = 0;
            } else {
                if (ws == -1) ws = i;
                if (isVowel(c)) cnt++;
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
