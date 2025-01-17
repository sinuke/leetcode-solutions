package com.sinuke.easy;

public class SplitStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int balance = 0, result = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') balance++;
            if (c == 'R') balance--;

            if (balance == 0) result++;
        }

        return result;
    }

}
