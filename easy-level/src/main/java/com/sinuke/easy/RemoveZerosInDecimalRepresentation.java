package com.sinuke.easy;

public class RemoveZerosInDecimalRepresentation {

    public long removeZeros(long n) {
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '0') sb.append(c);
        }
        return Integer.parseInt(sb.toString());
    }

}
