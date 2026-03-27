package com.sinuke.easy;

public class ArrangingCoins {

    public int arrangeCoins(int n) {
        return (int) (-0.5 + Math.sqrt((double) 2 * n + 0.25));
    }

}
