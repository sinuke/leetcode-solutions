package com.sinuke.easy;

import java.util.List;

public class CategorizeBoxAccordingToCriteria {

    // 0 ms
    public String categorizeBox2(int length, int width, int height, int mass) {
        int cat = (length >= 10_000 || width >= 10_000 || height >= 10_000 || ((long) length * width * height) >= 1_000_000_000) ? 1 : 0;
        cat += (mass >= 100) ? 2 : 0;
        return List.of("Neither", "Bulky", "Heavy", "Both").get(cat);
    }

    // 0 ms
    public String categorizeBox(int length, int width, int height, int mass) {
        long volume = (long) length * width * height;
        boolean isBulky = length >= 10_000 || width >= 10_000 || height >= 10_000 || volume >= 1_000_000_000;
        boolean isHeavy = mass >= 100;

        if (isBulky && isHeavy) return "Both";
        else if (!isBulky && !isHeavy) return "Neither";
        else if (isBulky && !isHeavy) return "Bulky";
        else return "Heavy";
    }

}
