package com.sinuke.easy;

public class MinimumStringLengthAfterRemovingSubstrings {

    public int minLength(String s) {
        int i1 = s.indexOf("AB");
        int i2 = s.indexOf("CD");

        do {
            if (i1 != -1) s = s.replaceAll("AB", "");
            if (i2 != -1) s = s.replaceAll("CD", "");

            i1 = s.indexOf("AB");
            i2 = s.indexOf("CD");
        } while (i1 != -1 || i2 != -1);

        return s.length();
    }

}
