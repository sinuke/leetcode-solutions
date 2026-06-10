package com.sinuke.easy;

public class MaximumEnemyFortsThatCanBeCaptured {

    public int captureForts(int[] forts) {
        int zeroes = 0, start = -2, i = 0, max = 0;

        while (i < forts.length) {
            if (forts[i] == 0) zeroes++;
            else if (forts[i] == 1) {
                if (start == -1) max = Math.max(max, zeroes);
                start = 1;
                zeroes = 0;
            } else if (forts[i] == -1) {
                if (start == 1) max = Math.max(max, zeroes);
                start = -1;
                zeroes = 0;
            }
            i++;
        }

        return max;
    }

}
