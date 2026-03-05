package com.sinuke.medium;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0, count = 0;
        while (i < players.length && j < trainers.length) {
            while (j < trainers.length && trainers[j] < players[i]) j++;
            if (j < trainers.length && trainers[j] >= players[i]) {
                count++;
                j++;
            }
            i++;
        }

        return count;
    }

}
