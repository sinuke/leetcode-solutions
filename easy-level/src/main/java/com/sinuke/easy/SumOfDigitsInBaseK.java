package com.sinuke.easy;

public class SumOfDigitsInBaseK {

    public int sumBase(int n, int k) {
        n = Integer.parseInt(Integer.toString(n, k), 10);
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}
