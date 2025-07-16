package com.sinuke.easy;

public class ConsecutiveCharacters {

    public int maxPower(String s) {
        int[] power = new int[26];
        int prev = s.charAt(0) - 'a', count = 1, max = 1;

        for (int i = 1; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (c == prev) count++;
            else {
                prev = c;
                count = 1;
            }
            power[c] = Math.max(power[c], count);
            max = Math.max(power[c], max);
        }

        return max;
    }

}
