package com.sinuke.medium;

public class ReverseWordsInString {

    public String reverseWords(String s) {
        int i = s.length() - 1, end = s.length();
        var sb = new StringBuilder();

        while (i > 0) {
            char current = s.charAt(i);
            char left = s.charAt(i - 1);

            if (current != ' ' && left == ' ') sb.append(s, i, end).append(' ');
            else if (current == ' ') end = i;

            i--;
        }
        if (s.charAt(0) != ' ') sb.append(s, 0, end).append(' ');
        if (!sb.isEmpty()) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
