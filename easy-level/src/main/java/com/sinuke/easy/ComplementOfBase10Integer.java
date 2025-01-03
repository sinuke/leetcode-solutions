package com.sinuke.easy;

public class ComplementOfBase10Integer {

    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int mask = (Integer.highestOneBit(n) << 1) - 1;
        return ~n & mask;
    }

}
