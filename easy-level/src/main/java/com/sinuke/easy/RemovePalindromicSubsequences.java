package com.sinuke.easy;

public class RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        return palindrome(s) ? 1 : 2;
    }

    private boolean palindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}
