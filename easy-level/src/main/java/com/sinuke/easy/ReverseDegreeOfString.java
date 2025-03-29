package com.sinuke.easy;

public class ReverseDegreeOfString {

    public int reverseDegree(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int reversed = Math.abs(s.charAt(i) - 'a' - 25) + 1;
            result += reversed * (i + 1);
        }

        return result;
    }

}
