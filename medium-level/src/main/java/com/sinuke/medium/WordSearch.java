package com.sinuke.medium;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                var res = false;
                if (board[i][j] == word.charAt(0)) {
                    res = check(board, i, j, 0, word);
                }
                if (res) return true;
            }
        }
        return false;
    }

    private boolean check(char[][] b, int i, int j, int indx, String w) {
        if (i < 0 || j < 0 || i == b.length || j == b[0].length || b[i][j] != w.charAt(indx)) return false;
        else if (indx == w.length() - 1) return true;

        char tmp = b[i][j];
        b[i][j] = '#';

        boolean result =  check(b, i - 1, j, indx + 1, w) ||
                check(b, i, j - 1, indx + 1, w) ||
                check(b, i + 1, j, indx + 1, w) ||
                check(b, i, j + 1, indx + 1, w);

        b[i][j] = tmp;
        return result;
    }

}
