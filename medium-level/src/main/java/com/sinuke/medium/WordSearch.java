package com.sinuke.medium;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        Result rslt = new Result();
        rslt.flg = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    check(board, i, j, 0, word, new HashSet<>(), rslt);
                }
                if (rslt.flg) return true;
            }
        }
        return false;
    }

    private void check(char[][] b, int i, int j, int indx, String w, Set<Coord> v, Result rslt) {
        Coord c = new Coord(i, j);

        if (i < 0 || j < 0 || i == b.length || j == b[0].length || b[i][j] != w.charAt(indx) || v.contains(c)) return;
        else if (indx == w.length() - 1) {
            rslt.flg = true;
            return;
        }

        Set<Coord> nv = new HashSet<>(v);
        nv.add(c);

        check(b, i - 1, j, indx + 1, w, nv, rslt);
        check(b, i, j - 1, indx + 1, w, nv, rslt);
        check(b, i + 1, j, indx + 1, w, nv, rslt);
        check(b, i, j + 1, indx + 1, w, nv, rslt);
    }

    private static class Result {
        boolean flg;
    }

    private record Coord(int i, int j) {}

}
