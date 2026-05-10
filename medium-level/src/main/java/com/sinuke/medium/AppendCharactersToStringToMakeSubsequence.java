package com.sinuke.medium;

public class AppendCharactersToStringToMakeSubsequence {

    public int appendCharacters(String s, String t) {
        int result = t.length();
        int si = 0, ti = 0;
        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
                ti++;
                result--;
            } else si++;
        }
        return result;
    }

}
