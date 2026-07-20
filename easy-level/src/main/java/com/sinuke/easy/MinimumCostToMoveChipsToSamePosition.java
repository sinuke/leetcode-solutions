package com.sinuke.easy;

public class MinimumCostToMoveChipsToSamePosition {
    public int minCostToMoveChips(int[] position) {
        int evenCnt = 0, oddCnt = 0;
        for (int p : position) {
            if (p % 2 == 0) evenCnt++;
            else oddCnt++;
        }

        return Math.min(evenCnt, oddCnt);
    }
}
