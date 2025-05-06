package com.sinuke.easy;

public class DeleteCharactersToMakeFancyString {

    public String makeFancyString(String s) {
        var sb = new StringBuilder();
        int start = 0, prev = 0, i = 1;

        while (i < s.length()) {
            if (s.charAt(i) != s.charAt(prev)) {
                sb.append(getSubstring(s, start, i));
                start = i;
            }
            prev = i;
            i++;
        }

        return sb.append(getSubstring(s, start, i)).toString();
    }

    private String getSubstring(String s, int start, int end) {
        var substr = s.substring(start, end);
        if (substr.length() > 2) return substr.substring(0, 2);
        else return substr;
    }

}
