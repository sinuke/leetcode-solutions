package com.sinuke.easy;

public class CountValidPrefixes {

    public int countValidPrefixes(String s) {
        int ans = 0, ones = 0, zeroes = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zeroes++;
            else ones++;

            if (Math.abs(ones - zeroes) < 2) ans++;
        }
        return ans;
    }

}