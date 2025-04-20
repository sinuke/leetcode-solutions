package com.sinuke.easy;

public class FindClosestPerson {

    public int findClosest(int x, int y, int z) {
        int result = 0;
        if (Math.abs(z - x) > Math.abs(z - y)) result = 2;
        else if (Math.abs(z - y) > Math.abs(z - x)) result = 1;
        return result;
    }

}
