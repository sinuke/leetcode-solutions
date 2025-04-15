package com.sinuke.easy;

public class MaximumValueOfStringInArray {

    public int maximumValue(String[] strs) {
        int max = Integer.MIN_VALUE;
        for (String s : strs) {
            max = Math.max(max, getValue(s));
        }
        return max;
    }

    private int getValue(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return str.length();
        }
    }

}
