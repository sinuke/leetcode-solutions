package com.sinuke.easy;

public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            result += isPrime2(Integer.bitCount(i)) ? 1 : 0;
        }
        return result;
    }

    private boolean isPrime(int n) {
        int count = 0;
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) count++;
        }
        return count == 0;
    }

    private boolean isPrime2(int n) {
        return n == 2 || n == 3 || n == 5 || n == 7 || n == 11 || n == 13 || n == 17 || n == 19;
    }

}
