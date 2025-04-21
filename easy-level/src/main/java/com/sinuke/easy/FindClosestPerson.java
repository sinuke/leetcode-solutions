package com.sinuke.easy;

public class FindClosestPerson {

    public int findClosest(int x, int y, int z) {
        int result = 0, zx = Math.abs(z - x), zy = Math.abs(z - y);
        if (zx > zy) result = 2;
        else if (zy > zx) result = 1;
        return result;
    }

}
