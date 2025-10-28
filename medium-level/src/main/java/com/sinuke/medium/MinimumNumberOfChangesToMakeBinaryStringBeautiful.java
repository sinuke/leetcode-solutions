package com.sinuke.medium;

public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {

    public int minChanges(String s) {
        int count = 0, i = 0;

        while (i < s.length() - 1) {
            count += s.charAt(i) == s.charAt(i + 1) ? 0 : 1;
            i += 2;
        }

        return count;
    }

}
