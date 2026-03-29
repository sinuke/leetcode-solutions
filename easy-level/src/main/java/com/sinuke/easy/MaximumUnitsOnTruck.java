package com.sinuke.easy;

import java.util.Arrays;
import java.util.Comparator;

class MaximumUnitsOnTruck {
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.<int[]>comparingInt(a -> a[1]).reversed());
        int i = 0, count = 0;
        while (i < boxTypes.length && truckSize > 0) {
            int boxes = Math.min(truckSize, boxTypes[i][0]);
            count += boxes * boxTypes[i++][1];
            truckSize -= boxes;
        }
        return count;
    }

}
