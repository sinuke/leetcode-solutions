package com.sinuke.easy;

import java.util.Arrays;
import java.util.Comparator;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int tmp = points[i + 1][0] - points[i][0];
            if (tmp > res) res = tmp;
        }
        return res;
    }

}
