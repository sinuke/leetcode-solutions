package com.sinuke.easy;

public class AlternatingDigitSum {

    public int alternateDigitSum(int n) {
        int sum = 0, sign = 1;
        for (char c : String.valueOf(n).toCharArray()) {
            sum += sign * (c - '0');
            sign *= -1;
        }
        return sum;
    }

}
