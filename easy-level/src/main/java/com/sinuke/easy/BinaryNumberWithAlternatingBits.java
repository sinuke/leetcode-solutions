package com.sinuke.easy;

public class BinaryNumberWithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        var binary = Integer.toBinaryString(n);
        for (int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i) == binary.charAt(i - 1)) return false;
        }
        return true;
    }

}
