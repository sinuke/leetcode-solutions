package com.sinuke.easy;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            String pattern = s.substring(0, i + 1);
            boolean flag = true;
            int j = i + 1;
            while (j < s.length() - pattern.length() && flag) {
                if (!pattern.equals(s.substring(j, j + pattern.length()))) flag = false;
                j++;
            }
            if (flag) return true;
        }

        return false;
    }

}
