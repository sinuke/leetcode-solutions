package com.sinuke.easy;

public class MaximumAreaOfLongestDiagonalRectangle {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int res = 0;
        double diag = 0.0d;
        for (int[] rect : dimensions) {
            double curDiag = Math.sqrt(rect[0] * rect[0] + rect[1] * rect[1]);
            if (curDiag > diag) {
                diag = curDiag;
                res = rect[0] * rect[1];
            } else if (curDiag == diag) res = Math.max(res, rect[0] * rect[1]);
        }
        return res;
    }

}
