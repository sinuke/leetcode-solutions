package com.sinuke.easy;

public class FindGreatestCommonDivisorOfArray {

    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int i = min; i > 0; i--) {
            if (min % i == 0 && max % i == 0) return i;
        }

        return 1;
    }

}
