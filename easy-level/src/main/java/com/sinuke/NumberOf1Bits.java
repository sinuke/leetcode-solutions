package com.sinuke;

public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int result = 0;
        int bit;
        while (n > 0) {
            bit = n % 2;
            if (bit == 1) result++;
            n = n / 2;
        }
        return result;
    }

}
