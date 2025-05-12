package com.sinuke.easy;

public class FindTheSumOfEncryptedIntegers {

    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += encrypt(num);
        return sum;
    }

    private int encrypt(int num) {
        int max = 0, count = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit > max) max = digit;
            num /= 10;
            count++;
        }

        int result = 0;
        while (count > 0) {
            result = result * 10 + max;
            count--;
        }

        return result;
    }

}
