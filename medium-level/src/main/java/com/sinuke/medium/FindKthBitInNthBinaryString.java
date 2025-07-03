package com.sinuke.medium;

public class FindKthBitInNthBinaryString {

    public char findKthBit(int n, int k) {
        var sb = new StringBuilder((int) Math.pow(2, n) - 1).append('0');

        for (int i = 1; i <= n; i++) {
            int l = sb.length();
            sb.append('1');
            for (int j = l - 1; j >= 0; j--) {
                sb.append((char) (((sb.charAt(j) - '0') ^ 1) + '0'));
            }
        }
        return sb.charAt(k - 1);
    }

}
