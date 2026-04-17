package com.sinuke.easy;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, image[sr][sc], color, sr, sc);
        return image;
    }

    private void fill(int[][] img, int color, int target, int r, int c) {
        if (r < 0 || r > img.length - 1 || c < 0 || c > img[0].length - 1 || img[r][c] != color || img[r][c] == target) return;

        img[r][c] = target;

        fill(img, color, target, r - 1, c);
        fill(img, color, target, r + 1, c);
        fill(img, color, target, r, c - 1);
        fill(img, color, target, r, c + 1);
    }

}
