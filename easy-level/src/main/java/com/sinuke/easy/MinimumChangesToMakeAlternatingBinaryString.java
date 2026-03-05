package com.sinuke.easy;

public class MinimumChangesToMakeAlternatingBinaryString {

    public int minOperations(String s) {
        int o1 = 0;
        char[] c1 = s.toCharArray();
        if (c1[0] == '0') {
            c1[0] = '1';
            o1++;
        }
        for (int i = 1; i < c1.length; i++) {
            if (c1[i] == c1[i - 1]) {
                c1[i] = c1[i - 1] == '0' ? '1' : '0';
                o1++;
            }
        }

        int o2 = 0;
        char[] c2 = s.toCharArray();
        if (c2[0] == '1') {
            c2[0] = '0';
            o2++;
        }
        for (int i = 1; i < c2.length; i++) {
            if (c2[i] == c2[i - 1]) {
                c2[i] = c2[i - 1] == '0' ? '1' : '0';
                o2++;
            }
        }

        return Math.min(o1, o2);
    }

}
