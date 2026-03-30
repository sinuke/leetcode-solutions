package com.sinuke.easy;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length() / 2; i++) {
            String pattern = s.substring(0, i + 1);
            boolean flag = true;
            int j = i + 1;
            while (j < s.length() && flag) {
                if (j + pattern.length() > s.length()) flag = false;
                else if (!pattern.equals(s.substring(j, j + pattern.length()))) flag = false;
                j += pattern.length();
            }
            if (flag) return true;
        }

        return false;
    }

}
