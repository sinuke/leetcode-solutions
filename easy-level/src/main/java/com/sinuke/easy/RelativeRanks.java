package com.sinuke.easy;

import java.util.Arrays;
import java.util.Comparator;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        int[][] ranks = new int[score.length][2];

        for (int i = 0; i < score.length; i++) {
            ranks[i][0] = score[i];
            ranks[i][1] = i;
        }

        Arrays.sort(ranks, Comparator.comparingInt(o -> o[0]));
        String[] result = new String[score.length];

        for (int i = ranks.length - 1; i >= 0; i--) {
            if (i == ranks.length - 1) result[ranks[i][1]] = "Gold Medal";
            else if (i == ranks.length - 2) result[ranks[i][1]] = "Silver Medal";
            else if (i == ranks.length - 3) result[ranks[i][1]] = "Bronze Medal";
            else result[ranks[i][1]] = String.valueOf(ranks.length - i);
        }

        return result;
    }

}
