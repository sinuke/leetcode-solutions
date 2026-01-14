package com.sinuke.easy;

public class FindNearestPointThatHasTheSameXOrYCoordinate {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1, dist = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            if (x == p[0] || y == p[1]) {
                int d = Math.abs(x - p[0]) + Math.abs(y - p[1]);
                if (d < dist) {
                    dist = d;
                    index = i;
                }
            }
        }
        return index;
    }

}
