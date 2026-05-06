package com.sinuke.medium;

public class RotatingTheBox {

    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] res = new char[boxGrid[0].length][boxGrid.length];

        for (int i = 0; i < boxGrid.length; i++) {
            for (int j = 0; j < boxGrid[i].length; j++) {
                res[j][res[0].length - i - 1] = boxGrid[i][j];
            }
        }

        for (int j = 0; j < res[0].length; j++) {
            for (int i = res.length - 1; i > 0; i--) {
                if (res[i][j] == '.') {
                    int k = i;
                    while (k != 0 && res[k][j] == '.') k--;
                    if (res[k][j] == '#') {
                        res[k][j] = '.';
                        res[i][j] = '#';
                    }
                }
            }
        }

        return res;
    }

}
