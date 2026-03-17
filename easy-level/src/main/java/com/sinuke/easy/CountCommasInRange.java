package com.sinuke.easy;

public class CountCommasInRange {

    // 1 ms
    public int countCommas(int n) {
        return (n < 1000) ? 0 : n - 1000 + 1;
    }

    // 232 ms
    public int countCommas2(int n) {
        if (n < 1000) return 0;
        int count = 0;
        for (int i = 1000; i <= n; i++) {
            int l = String.valueOf(i).length();
            count += (l % 3 == 0) ? l / 3 - 1 : l / 3;
        }
        return count;
    }

}
