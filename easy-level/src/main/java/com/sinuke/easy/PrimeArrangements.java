package com.sinuke.easy;

import java.util.Set;

class PrimeArrangements {

    private static final Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
    private static final int mod = 1_000_000_007;

    public int numPrimeArrangements(int n) {
        int pcnt = 0;

        for (int i = 1; i <= n; i++) {
            if (primes.contains(i)) pcnt++;
        }

        long factorialPrime = factorial(pcnt) % mod;
        long factorialComposite = factorial(n - pcnt) % mod;

        return (int) ((factorialPrime * factorialComposite) % mod);
    }

    private long factorial(int n) {
        long f = 1L;
        for (int i = 2; i <= n; i++) {
            f = (f * i) % mod;
        }
        return f;
    }

}
