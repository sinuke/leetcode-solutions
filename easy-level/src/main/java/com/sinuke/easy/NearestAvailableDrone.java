package com.sinuke.easy;

public class NearestAvailableDrone {

    public int nearestDrone(int[][] drones, int[] target) {
        int r = -1, dist = Integer.MAX_VALUE;
        for (int i = 0; i < drones.length; i++) {
            int d = getDist(drones[i][0], drones[i][1], target[0], target[1]);
            if (d <= drones[i][2]) {
                if (d < dist) {
                    r = i;
                    dist = d;
                }
            }
        }
        return r;
    }

    private int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}
