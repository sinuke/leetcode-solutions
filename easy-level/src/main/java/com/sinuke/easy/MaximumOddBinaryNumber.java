package com.sinuke.easy;

public class MaximumOddBinaryNumber {

    public String maximumOddBinaryNumber(String s) {
        var sb = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') count++;
            else sb.append("0");
        }
        sb.append("1");
        for (int i = 0; i < count - 1; i++) {
            sb.insert(0, "1");
        }
        return sb.toString();
    }

}
