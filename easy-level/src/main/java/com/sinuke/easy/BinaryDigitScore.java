package com.sinuke.easy;

public class BinaryDigitScore {

    public int calculateScore(int a, int b) {
        int s1 = 0, s2 = 0;
        for (char d : Integer.toBinaryString(a).toCharArray()) {
            if (d == '1') s1++;
        }

        for (char d : Integer.toBinaryString(b).toCharArray()) {
            if (d == '1') s2++;
        }

        return s1 >= s2 ? s1 * s2 : s2 / s1;
    }

}
