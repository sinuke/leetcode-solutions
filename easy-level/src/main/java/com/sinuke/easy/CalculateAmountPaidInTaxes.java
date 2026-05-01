package com.sinuke.easy;

public class CalculateAmountPaidInTaxes {

    public double calculateTax(int[][] brackets, int income) {
        double tax  = Math.min(income, brackets[0][0]) * brackets[0][1] * 0.01d;
        for (int i = 1; i < brackets.length; i++) {
            int k = Math.min(income, brackets[i][0]) - brackets[i - 1][0];
            if (k < 0) break;
            tax += k * brackets[i][1] * 0.01d;
        }
        return tax;
    }

}
