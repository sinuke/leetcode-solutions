package com.sinuke.easy;

class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // clockwise
        int d1 = 0;
        int i = start;
        do {
            d1 += distance[i];
            i++;
            if (i == distance.length) i = 0;
        } while (i != destination);

        //counterclockwise
        int d2 = 0;
        i = destination;
        do {
            d2 += distance[i];
            i++;
            if (i == distance.length) i = 0;
        } while (i != start);

        return Math.min(d1, d2);
    }

}
