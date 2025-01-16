package com.sinuke.easy;

import java.util.Arrays;

public class MinimumSumOfFourDigitNumberAfterSplittingDigits {

    public int minimumSum(int num) {
        var digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return Integer.parseInt(digits[0] + "" + digits[2]) + Integer.parseInt(digits[1] + "" + digits[3]);
    }

}
