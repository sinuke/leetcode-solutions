package com.sinuke.medium;

public class QueriesOnNumberOfPointsInsideCircle {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length;i ++) {
            int[] query = queries[i];
            for (int[] point : points) {
                if (Math.sqrt(Math.pow(query[0] - point[0], 2) + Math.pow(query[1] - point[1], 2)) <= query[2]) result[i]++;
            }
        }
        return result;
    }

}
