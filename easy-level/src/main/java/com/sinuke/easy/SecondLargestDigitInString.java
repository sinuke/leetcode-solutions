package com.sinuke.easy;

public class SecondLargestDigitInString {

    public int secondHighest(String s) {
        int max = -1, second = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (c - '0' > max) {
                    second = max;
                    max = c - '0';
                } else if (c - '0' > second && c - '0' != max) second = c - '0';
            }
        }
        return second;
    }

}
