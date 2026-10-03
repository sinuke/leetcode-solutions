package com.sinuke.easy;

public class FindLosersOfCircularGame {

    public int[] circularGameLosers(int n, int k) {
        int round = 1, i = 1, cnt = 0;
        byte[] p = new byte[n + 1];
        while (p[i] != 1) {
            p[i] = 1;
            cnt++;
            i = (i + round * k) % n;
            round++;
        }

        int[] losers = new int[n - cnt];
        i = 0;
        for (int j = 1; j <= n; j++) {
            if (p[j] == 0) losers[i++] = j;
        }
        return losers;
    }

}
