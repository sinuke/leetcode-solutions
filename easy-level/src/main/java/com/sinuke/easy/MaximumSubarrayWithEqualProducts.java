package com.sinuke.easy;

class MaximumSubarrayWithEqualProducts {

    public int maxLength(int[] nums) {
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            long p = nums[i];
            long g = nums[i];
            long l = lcm(1, nums[i]);

            for (int j = i + 1; j < nums.length; j++) {
                p *= nums[j];
                g = Math.min(g, gcd(nums[j - 1], nums[j]));
                l = lcm(l, nums[j]);

                if (p == l * g) result = Math.max(result, j - i + 1);
                else if (p > l * g) break;
            }

        }
        return result;
    }

    private long lcm(long a, int b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        while (b > 0) {
            a %= b;
            long c = a;
            a = b;
            b = c;
        }
        return a;
    }

}
