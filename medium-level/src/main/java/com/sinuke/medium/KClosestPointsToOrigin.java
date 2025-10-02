package com.sinuke.medium;

import java.util.Arrays;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> Double.compare(distance(a), distance(b)));
        return Arrays.copyOf(points, k);
    }

    private double distance(int[] p) {
        return Math.sqrt(p[0] * p[0] + p[1] * p[1]);
    }

}
