package com.sinuke.easy;

public class CheckBalancedString {

    public boolean isBalanced(String num) {
        int oddSum = 0, evenSum = 0;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (i % 2 == 0) evenSum += c - '0';
            else oddSum += c - '0';
        }

        return oddSum == evenSum;
    }

}
