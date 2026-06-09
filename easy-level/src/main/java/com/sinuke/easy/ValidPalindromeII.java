package com.sinuke.easy;

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return isPalindrome(s.substring(l, r)) || isPalindrome(s.substring(l + 1, r + 1));
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}
