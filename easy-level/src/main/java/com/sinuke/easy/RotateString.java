package com.sinuke.easy;

public class RotateString {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        var sb = new StringBuilder(s);
        int shifts = 0;
        while (shifts < s.length()) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0).append(c);
            if (sb.toString().equals(goal)) return true;
            shifts++;
        }

        return false;
    }

}
