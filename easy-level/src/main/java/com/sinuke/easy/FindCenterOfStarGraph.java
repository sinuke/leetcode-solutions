package com.sinuke.easy;

public class FindCenterOfStarGraph {

    public int findCenter(int[][] edges) {
        int[] counts = new int[10001];
        int center = 0;

        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
            center = counts[edge[0]] > 1 ? edge[0] : edge[1];
        }

        return center;
    }

}
