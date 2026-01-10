package com.sinuke.easy;

public class FindTheMaximumDivisibilityScore {

    public int maxDivScore(int[] nums, int[] divisors) {
        int maxScore = 0, minDivisor = 1001;

        for (int divisor : divisors) {
            int score = 0;

            for (int num : nums) {
                if (num % divisor == 0) score++;
            }

            if (score > maxScore || (score == maxScore && divisor < minDivisor)) {
                maxScore = score;
                minDivisor = divisor;
            }
        }

        return minDivisor;
    }

}
