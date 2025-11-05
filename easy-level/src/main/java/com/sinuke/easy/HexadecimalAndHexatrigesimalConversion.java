package com.sinuke.easy;

public class HexadecimalAndHexatrigesimalConversion {

    public String concatHex36(int n) {
        return (Integer.toString(n * n, 16) + Integer.toString(n * n * n, 36)).toUpperCase();
    }

}
