package com.sinuke.medium;

public class MaximizeSumOfSquaresOfDigits {

    public String maxSumOfSquares(int num, int sum) {
        var sb = new StringBuilder();
        int i = 0;
        while (sum > 9) {
            sb.append(9);
            sum -= 9;
            i++;
        }
        if (sum > 0) {
            sb.append(sum);
            i++;
        }
        while (i < num) {
            sb.append(0);
            i++;
        }
        return i == num ? sb.toString() : "";
    }

}
