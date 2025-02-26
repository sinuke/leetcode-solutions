package com.sinuke.easy;

public class FindTheHighestAltitude {

    public int largestAltitude(int[] gain) {
        int max = 0, current = 0;

        for (int g : gain) {
            current += g;
            max = Math.max(max, current);
        }

        return max;
    }

}
