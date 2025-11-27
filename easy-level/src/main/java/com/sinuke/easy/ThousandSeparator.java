package com.sinuke.easy;

public class ThousandSeparator {

    public String thousandSeparator(int n) {
        if (n == 0) return "0";

        var sb = new StringBuilder();
        int k = 0;
        while (n > 0) {
            sb.append(n % 10);
            k++;
            if (k % 3 == 0) sb.append('.');
            n /= 10;
        }

        if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == '.') sb.setLength(sb.length() - 1);
        return sb.reverse().toString();
    }

}
