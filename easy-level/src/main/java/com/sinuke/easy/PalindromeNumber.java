package com.sinuke.easy;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int y = x;
        int z = 0;
        do {
            z = z * 10 + y % 10;
            y = y / 10;
        } while (y != 0);

        return z == x;
    }

}
