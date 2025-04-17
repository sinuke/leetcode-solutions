package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class RingsAndRods {

    public int countPoints(String rings) {
        int[][] counts = new int[10][3];
        int i = 0;
        Set<Integer> set = new HashSet<>();
        while (i < rings.length() - 1) {
            int rod = rings.charAt(i + 1) - '0';
            char color = rings.charAt(i);
            if (color == 'R') counts[rod][0] += 1;
            else if (color == 'G') counts[rod][1] += 1;
            else if (color == 'B') counts[rod][2] += 1;

            if (counts[rod][0] > 0 && counts[rod][1] > 0 && counts[rod][2] > 0) {
                set.add(rod);
            }

            i += 2;
        }

        return set.size();
    }

}
