package com.sinuke.easy;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    public boolean checkOnesSegment(String s) {
        char p = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (p == '0' && c == '1') return false;
            p = c;
        }

        return true;
    }

}
