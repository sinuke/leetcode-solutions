package com.sinuke.easy;

public class ConstructTheRectangle {

    public int[] constructRectangle(int area) {
        int l = (int) Math.sqrt(area);
        int w = l;

        while (l * w != area) {
            l++;
            w = area / l;
        }

        return new int[] {l, w};
    }

}
