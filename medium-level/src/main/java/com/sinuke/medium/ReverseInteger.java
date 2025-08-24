package com.sinuke.medium;

public class ReverseInteger {

    public int reverse(int x) {
        int multiplier = x < 0 ? -1 : 1, result = 0;
        x = Math.abs(x);

        while (x > 0) {
            int d = x % 10;
            if (((result * 10 + d) - d) / 10 != result) return 0;
            result = result * 10 + d;
            x /= 10;
        }

        return result * multiplier;
    }

}
