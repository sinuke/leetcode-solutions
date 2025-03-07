package com.sinuke.easy;

public class HarshadNumber {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int original = x;
        int sum = 0;

        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return original % sum == 0 ? sum : -1;
    }

}
