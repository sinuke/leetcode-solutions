package com.sinuke.medium;

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else count--;
        }
        return Math.abs(count);
    }

}
