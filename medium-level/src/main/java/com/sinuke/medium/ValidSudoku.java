package com.sinuke.medium;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        byte[][] rows = new byte[n][n];
        byte[][] columns = new byte[n][n];
        byte[][] boxes = new byte[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.') continue;

                int d = (board[r][c] - '0') - 1;
                if (rows[r][d] == 1) return false;
                else rows[r][d]++;

                if (columns[c][d] == 1) return false;
                else columns[c][d]++;

                int b = (c / 3) + (r / 3) * 3;
                if (boxes[b][d] == 1) return false;
                else boxes[b][d]++;
            }
        }

        return true;
    }

}
