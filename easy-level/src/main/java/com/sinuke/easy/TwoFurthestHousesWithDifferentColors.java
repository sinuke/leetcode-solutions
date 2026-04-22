package com.sinuke.easy;

public class TwoFurthestHousesWithDifferentColors {

    // 0 ms
    public int maxDistance(int[] colors) {
        int i = 0, j = colors.length - 1;
        while (j > i && colors[i] == colors[j]) {
            j--;
        }
        int max = j - i;

        i = 0;
        j = colors.length - 1;
        while (j > i && colors[i] == colors[j]) {
            i++;
        }

        return Math.max(max, j - i);
    }

    // 2 ms
    public int maxDistance2(int[] colors) {
        int max = 0;
        for (int i = 0; i < colors.length - 1; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]) max = Math.max(max, j - i);
            }
        }
        return max;
    }

}
