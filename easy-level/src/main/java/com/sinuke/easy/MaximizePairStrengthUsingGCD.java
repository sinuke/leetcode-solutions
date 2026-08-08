package com.sinuke.easy;

public class MaximizePairStrengthUsingGCD {

    public long maxPairStrength(int[] nums) {
        long strength = 0L;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long prod = ((long) nums[i]) * ((long) nums[j]);
                long gcd = gcd(nums[i], nums[j]);
                strength = Math.max(strength, prod / (gcd * gcd));
            }
        }
        return strength;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

}
