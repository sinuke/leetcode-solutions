package com.sinuke.easy;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int si = 0, ti = 0, count = 0;

        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
                count++;
            }

            ti++;
        }

        return count == s.length();
    }

}
