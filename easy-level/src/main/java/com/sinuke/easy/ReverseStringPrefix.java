package com.sinuke.easy;

public class ReverseStringPrefix {

    // 1 ms
    public String reversePrefix(String s, int k) {
        var sb = new StringBuilder();
        for (int i = k - 1; i >= 0; i--) sb.append(s.charAt(i));
        for (int i = k; i < s.length(); i++) sb.append(s.charAt(i));
        return sb.toString();
    }

    // 3 ms
    public String reversePrefix2(String s, int k) {
        return new StringBuilder(s.substring(0, k)).reverse().toString() + s.substring(k);
    }

}
