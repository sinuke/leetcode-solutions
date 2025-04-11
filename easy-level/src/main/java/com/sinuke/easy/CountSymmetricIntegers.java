package com.sinuke.easy;

public class CountSymmetricIntegers {

    public int countSymmetricIntegers(int low, int high) {
        int result = 0;
        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) result++;
        }
        return result;
    }

    private boolean isSymmetric(int num) {
        var s = String.valueOf(num);
        if (num < 10 || s.length() % 2 != 0) return false;

        int left = 0, right = 0, n = s.length() / 2;
        for (int i = 0; i < n; i++) {
            left += s.charAt(i) - '0';
            right += s.charAt(n + i) - '0';
        }

        return left == right;
    }

}
