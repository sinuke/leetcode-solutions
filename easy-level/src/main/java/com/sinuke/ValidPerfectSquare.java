package com.sinuke;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        var sqrtNum = mySqrt(num);
        return sqrtNum * sqrtNum == num;
    }

    private int mySqrt(int x) {
        if (x == 1) return x;

        int low = 1;
        int high = x;
        int result = 0;

        while (low < high) {
            if (low == 46341) return low -1;

            int mid = low + (high - low) / 2;
            mid = Math.min(mid, 46340);
            int sqr = mid * mid;

            if (sqr == x) return mid;
            else if (sqr > x) high = mid;
            else {
                low = mid + 1;
                result = mid;
            }
        }

        return result;
    }

}
