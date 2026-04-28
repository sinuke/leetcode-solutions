package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorInCircularTrack {

    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] cnts = new int[n + 1];
        int j = rounds[0], max = 1;
        cnts[j]++;
        for (int i = 1; i < rounds.length; i++) {
            j = rounds[i - 1];

            while (j != rounds[i]) {
                j++;
                if (j > n) j = 1;
                cnts[j]++;
                max = Math.max(max, cnts[j]);
            }
        }

        List<Integer> result = new ArrayList<>(n);
        for (int i = 1; i < cnts.length; i++) {
            if (cnts[i] == max) result.add(i);
        }

        return result;
    }

}
