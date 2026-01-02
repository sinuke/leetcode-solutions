package com.sinuke.easy;

public class NumberOfBeautifulPairs {

    public int countBeautifulPairs(int[] nums) {
        int cnt = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = String.valueOf(nums[i]).charAt(0) - '0';
                int y = nums[j] % 10;

                cnt += gcd(x, y) == 1 ? 1 : 0;
            }
        }

        return cnt;
    }

    private int gcd(int x, int y) {
        for (int i = Math.min(x, y); i > 1; i--) {
            if (x % i == 0 && y % i == 0) return i;
        }

        return 1;
    }

}
