package com.sinuke.medium;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

    private final char[] chars = new char[] {'a', 'b', 'c'};
    private String result = null;

    public String getHappyString(int n, int k) {
        backtrack(n, k, "");
        return result == null ? "" : result;
    }

    private int backtrack(int n, int k, String str) {
        if (str.length() == n) {
            k--;
            if (k == 0) result = str;
            return k;
        }

        for (var c : chars) {
            if (str.isEmpty() || str.charAt(str.length() - 1) != c) {
                k = backtrack(n, k, str + c);
                if (k == 0) break;
            }
        }

        return k;
    }

}
