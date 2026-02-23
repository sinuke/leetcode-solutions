package com.sinuke.easy;

public class BinaryGap {

    public int binaryGap(int n) {
        char[] bits = Integer.toBinaryString(n).toCharArray();
        int prev = bits[0] == '1' ? 0 : bits.length, distance = 0;
        for (int i = 1; i < bits.length; i++) {
            if (bits[i] == '1') {
                distance = Math.max(distance, i - prev);
                prev = i;
            }
        }
        return distance;
    }

}
