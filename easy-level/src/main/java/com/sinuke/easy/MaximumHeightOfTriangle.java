package com.sinuke.easy;

public class MaximumHeightOfTriangle {

    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(getHeight(red, blue), getHeight(blue, red));
    }

    private static int getHeight(int red, int blue) {
        int rh = 0;

        while (red >= 0 && blue >= 0) {
            rh++;

            if (rh % 2 == 0) blue -= rh;
            else red -= rh;

            if (blue < 0 || red < 0) {
                rh--;
                break;
            }
        }
        return rh;
    }

}
