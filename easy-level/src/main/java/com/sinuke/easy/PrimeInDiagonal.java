package com.sinuke.easy;

public class PrimeInDiagonal {

    public int diagonalPrime(int[][] nums) {
        int n = nums.length, result = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i][i] > result && isPrime(nums[i][i])) result = Math.max(result, nums[i][i]);
            if (nums[i][n - i - 1] > result && isPrime(nums[i][n - i - 1])) result = Math.max(result, nums[i][n - i - 1]);
        }
        return result;
    }

    private boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

}
