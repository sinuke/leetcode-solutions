package com.sinuke.medium;

public class CheckIfNumberIsSumOfPowersOfThree {

    public boolean checkPowersOfThree(int n) {
        var sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        var digits = sb.reverse().toString();

        return !digits.contains("2");
    }

}
