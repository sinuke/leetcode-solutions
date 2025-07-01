package com.sinuke.easy;

public class FindTheOriginalTypedStringI {

    public int possibleStringCount(String word) {
        int result = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) result++;
        }
        return result;
    }

}
