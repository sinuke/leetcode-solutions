package com.sinuke.easy;

public class StoneRemovalGame {

    public boolean canAliceWin(int n) {
        int step = 10;
        boolean aliceTurn = true;
        while (n >= 0) {
            n -= step;
            aliceTurn = !aliceTurn;
            step--;
        }
        return aliceTurn;
    }

}
