package com.sinuke.easy;

public class NumberOfSegmentsInString {

    public int countSegments(String s) {
        if (s.isEmpty()) return 0;

        int count = 0;
        boolean prevSpace = s.charAt(0) == ' ';
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && !prevSpace) {
                count++;
                prevSpace = true;
            } else if (s.charAt(i) != ' ') prevSpace = false;
        }

        if (!prevSpace) count++;
        return count;
    }

}
