package com.sinuke.easy;

public class CheckIfDigitsAreEqualInStringAfterOperationsI {

    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            s = makeOperations(s);
        }
        return s.charAt(0) == s.charAt(1);
    }

    private String makeOperations(String s) {
        var sb = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            int d1 = s.charAt(i) - '0';
            int d2 = s.charAt(i + 1) - '0';
            sb.append((d1 + d2) % 10);
        }

        return sb.toString();
    }

}
