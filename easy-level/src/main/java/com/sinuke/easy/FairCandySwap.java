package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Set<Integer> b = new HashSet<>(bobSizes.length);
        int asum = 0, bsum = 0;
        for (int s : aliceSizes) asum += s;

        for (int s : bobSizes) {
            b.add(s);
            bsum += s;
        }

        int d = (bsum - asum) / 2;
        for (int s : aliceSizes) {
            if (b.contains(d + s)) return new int[] {s, d + s};
        }

        return new int[] {-1, -1};
    }

}
