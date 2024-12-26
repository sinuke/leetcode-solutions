package com.sinuke.easy;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;

        int low = 1;
        int high = num;

        while (low < high) {
            if (low == 46341) return false;

            int mid = low + (high - low) / 2;
            mid = Math.min(mid, 46340);
            int sqr = mid * mid;

            if (sqr == num) return true;
            else if (sqr > num) high = mid;
            else low = mid + 1;
        }

        return false;
    }

}
