package com.sinuke.easy;

public class NumberOfRectanglesThatCanFormTheLargestSquare {

    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0, count = 0;
        for (int[] rect : rectangles) maxLen = Math.max(maxLen, Math.min(rect[0], rect[1]));
        for (int[] rect : rectangles) count += (Math.min(rect[0], rect[1]) == maxLen) ? 1 : 0;
        return count;
    }

}
