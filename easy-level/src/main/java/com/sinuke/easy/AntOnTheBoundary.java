package com.sinuke.easy;

public class AntOnTheBoundary {

    public int returnToBoundaryCount(int[] nums) {
        int value = 0, count = 0;
        for (int move : nums) {
            value += move;
            if (value == 0) count++;
        }
        return count;
    }

}
