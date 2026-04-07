package com.sinuke.easy;

public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.abs(rec1[2] - rec1[0]) * Math.abs(rec1[3] - rec1[0]) == 0) ||
                (Math.abs(rec2[2] - rec2[0]) * Math.abs(rec2[3] - rec2[0]) == 0) ||
                (rec1[0] >= rec2[2] || rec1[1] >= rec2[3] || rec2[0] >= rec1[2] || rec2[1] >= rec1[3])
                ? false
                : true;
    }

}
