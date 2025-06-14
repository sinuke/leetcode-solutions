package com.sinuke.easy;

public class MaximumDifferenceByRemappingDigit {

    public int minMaxDifference(int num) {
        var numStr = String.valueOf(num);

        int maxToReplace = -1, minToReplace = -1;
        var result = new StringBuilder();

        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            int min = digit, max = digit;

            if (digit != 9 && maxToReplace == -1) {
                maxToReplace = digit;
                max = 9;
            } else if (digit == maxToReplace) max = 9;

            if (digit != 0 && minToReplace == -1) {
                minToReplace = digit;
                min = 0;
            } else if (digit == minToReplace) min = 0;

            result.append(max - min);
        }

        return Integer.parseInt(result.toString());
    }

}
