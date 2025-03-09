package com.sinuke.easy;

public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        boolean hasAxisColumn = n % 2 != 0;

        for (int i = 0; i < n; i++) {
            int k = hasAxisColumn ? n / 2 : n / 2 - 1;
            for (int j = 0; j <= k; j++) {
                if (!hasAxisColumn || j != n / 2) {
                    int tmp = image[i][j];
                    image[i][j] = image[i][n - 1 - j];
                    image[i][n - 1 - j] = tmp;

                    image[i][n - 1 - j] ^= 1;
                }

                image[i][j] ^= 1;
            }
        }

        return image;
    }

}
