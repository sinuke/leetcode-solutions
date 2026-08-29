package com.sinuke.easy;

public class CheckAsciiPalindromic {

    public boolean isPalindromic(String s) {
        var sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(getBits(c));
        }

        return isPalindrome(sb);
    }

    private String getBits(char c) {
        return String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
    }

    private boolean isPalindrome(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - i - 1)) return false;
        }
        return true;
    }

}
