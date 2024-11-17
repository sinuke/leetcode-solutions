package com.sinuke;

public class FindIndexFirstOccurrenceString {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) return -1;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.startsWith(needle, i)) return i;
        }

        return -1;
    }

}
