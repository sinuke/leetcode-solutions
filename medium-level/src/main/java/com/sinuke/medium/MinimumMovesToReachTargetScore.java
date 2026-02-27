package com.sinuke.medium;

public class MinimumMovesToReachTargetScore {

    public int minMoves(int target, int maxDoubles) {
        if (target == 1) return 0;

        int moves = 0;

        while (maxDoubles > 0 && target > 1) {
            if (target % 2 != 0) {
                target--;
                moves++;
            }
            target /= 2;
            moves++;
            maxDoubles--;
        }

        return target != 1 ? moves + target - 1 : moves;
    }

}
