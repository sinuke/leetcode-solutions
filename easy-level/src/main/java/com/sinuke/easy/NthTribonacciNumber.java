package com.sinuke.easy;

public class NthTribonacciNumber {

    // 0(n)
    public int tribonacci(int n) {
        int[] mem = new int[38];
        mem[1] = 1;
        mem[2] = 1;
        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 3] + mem[i - 2] + mem[i -1];
        }
        return mem[n];
    }

    // O(n^3)
    public int tribonacci2(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;
        return tribonacci2(n - 1) + tribonacci2(n - 2) + tribonacci2(n - 3);
    }

    // O(1)
    public int tribonacci3(int n) {
        int[] nums = {
                0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149,
                274, 504, 927, 1705, 3136, 5768, 10609,
                19513, 35890, 66012, 121415, 223317, 410744,
                755476, 1389537, 2555757, 4700770, 8646064,
                15902591, 29249425, 53798080, 98950096,
                181997601, 334745777, 615693474, 1132436852,
                2082876103
        };
        return nums[n];
    }

}
