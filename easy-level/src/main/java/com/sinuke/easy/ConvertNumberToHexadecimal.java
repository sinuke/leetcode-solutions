package com.sinuke.easy;

public class ConvertNumberToHexadecimal {

    public String toHex(int num) {
        if (num == 0) return "0";

        var hexChars = "0123456789abcdef";
        long n = num < 0 ? (long) Math.pow(2, 32) + num : num;

        var sb = new StringBuilder();
        while (n > 0) {
            int i = (int) (n % 16);
            sb.append(hexChars.charAt(i));
            n /= 16;
        }

        return sb.reverse().toString();
    }

}
