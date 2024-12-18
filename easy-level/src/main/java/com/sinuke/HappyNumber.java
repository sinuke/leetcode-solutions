package com.sinuke;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> numbers = new HashSet<>();

        while (n != 1 && !numbers.contains(n)) {
            numbers.add(n);
            n = findSumOfSquares(n);
        }

        return n == 1;
    }

    private int findSumOfSquares(int n) {
        int sum = 0;

        while (n > 0) {
            int val = n % 10;
            sum += val * val;
            n /= 10;
        }

        return sum;
    }

}
