package com.sinuke.easy;

public class ImageSmoother {

    public int[][] imageSmoother(int[][] img) {
        int[][] result = new int[img.length][img[0].length];

        for (int x = 0; x < img.length; x++) {
            for (int y = 0; y < img[x].length; y++) {
                int avg = calculateAvg(img, x, y);
                result[x][y] = avg;
            }
        }

        return result;
    }

    private int calculateAvg(int[][] img, int x, int y) {
        int count = 1;
        int sum = img[x][y];

        // 0 0 0
        // * x 0
        // 0 0 0
        if (x > 0) {
            sum += img[x - 1][y];
            count++;
        }

        // 0 * 0
        // 0 x 0
        // 0 0 0
        if (y > 0) {
            sum += img[x][y - 1];
            count++;
        }

        // 0 0 0
        // 0 x *
        // 0 0 0
        if (x < img.length - 1) {
            sum += img[x + 1][y];
            count++;
        }

        // 0 0 0
        // 0 x 0
        // 0 * 0
        if (y < img[x].length - 1) {
            sum += img[x][y + 1];
            count++;
        }

        // * 0 0
        // 0 x 0
        // 0 0 0
        if (x > 0 && y > 0) {
            sum += img[x - 1][y - 1];
            count++;
        }

        // 0 0 0
        // 0 x 0
        // * 0 0
        if (x > 0 && y < img[x].length - 1) {
            sum += img[x - 1][y + 1];
            count++;
        }

        // 0 0 *
        // 0 x 0
        // 0 0 0
        if (y > 0 && x < img.length - 1) {
            sum += img[x + 1][y - 1];
            count++;
        }

        // 0 0 0
        // 0 x 0
        // 0 0 *
        if (x < img.length - 1 && y < img[x].length - 1) {
            sum += img[x + 1][y + 1];
            count++;
        }

        return sum / count;
    }
}
