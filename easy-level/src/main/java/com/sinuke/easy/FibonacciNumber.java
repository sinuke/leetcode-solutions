package com.sinuke.easy;

public class FibonacciNumber {

    // O(N^2) - 8 ms
    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    // O(N) - 0 ms
    public int fib2(int n) {
        int[] fib = new int[n + 2];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }

        return fib[n];
    }

    // O(1) - 0 ms
    public int fib3(int n) {
        int[] fib = {
                0,1,1,2,3,5,8,13,21,34,55,89,144,
                233,377,610,987,1597,2584,4181,
                6765,10946,17711,28657,46368,
                75025,121393,196418,317811,514229,832040
        };

        return fib[n];
    }

}
