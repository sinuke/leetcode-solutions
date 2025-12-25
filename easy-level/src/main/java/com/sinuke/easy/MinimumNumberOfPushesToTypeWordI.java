package com.sinuke.easy;

public class MinimumNumberOfPushesToTypeWordI {

    public int minimumPushes(String word) {
        int n = word.length();

        if (n <= 8) return n;
        else if (n <= 16) return 8 + (n - 8) * 2;
        else if (n <= 24) return 16 + (n - 16) * 3;
        else return 24 + (24 - n) * 4;
    }

}
