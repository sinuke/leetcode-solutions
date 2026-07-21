package com.sinuke.easy;

public class EvenNumberOfKnightMoves {

    public boolean canReach(int[] start, int[] target) {
        return (start[0] + start[1]) % 2 == (target[0] + target[1]) % 2;
    }

}
