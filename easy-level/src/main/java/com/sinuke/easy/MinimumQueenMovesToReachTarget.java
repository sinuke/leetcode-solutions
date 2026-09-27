package com.sinuke.easy;

public class MinimumQueenMovesToReachTarget {

    public int minQueenMoves(int[] source, int[] target) {
        if (source[0] == target[0] && source[1] == target[1]) return 0;
        else if (source[0] == target[0] || source[1] == target[1] || source[0] - source[1] == target[0] - target[1] || source[0] + source[1] == target[0] + target[1]) return 1;
        else return 2;
    }

}
