package com.sinuke.easy;

public class FindWinnerOnTicTacToeGame {

    public String tictactoe(int[][] moves) {
        int[][] f = new int[3][3];
        int turn = 1;
        for (int[] move : moves) {
            f[move[0]][move[1]] = turn;
            if (isWinner(f, turn)) return turn == 1 ? "A" : "B";
            turn ^= 3;
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    private boolean isWinner(int[][] f, int p) {
        return (f[0][0] == p && f[0][1] == p && f[0][2] == p) ||
                (f[1][0] == p && f[1][1] == p && f[1][2] == p) ||
                (f[2][0] == p && f[2][1] == p && f[2][2] == p) ||

                (f[0][0] == p && f[1][0] == p && f[2][0] == p) ||
                (f[0][1] == p && f[1][1] == p && f[2][1] == p) ||
                (f[0][2] == p && f[1][2] == p && f[2][2] == p) ||

                (f[0][0] == p && f[1][1] == p && f[2][2] == p) ||
                (f[0][2] == p && f[1][1] == p && f[2][0] == p);
    }

}
