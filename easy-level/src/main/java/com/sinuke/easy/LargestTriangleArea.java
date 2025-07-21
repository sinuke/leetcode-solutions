package com.sinuke.easy;

public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        double max = 0;

        for (int i = 0; i < points.length - 2; i ++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    max = Math.max(getArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]), max);
                }
            }
        }

        return max;
    }

    private double getArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x2 * y1 - x3 * y2 - x1 * y3)) * 0.5d;
    }

}
