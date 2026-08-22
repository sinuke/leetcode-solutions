package com.sinuke.easy;

public class DetermineTheWinnerOfBowlingGame {

    public int isWinner(int[] player1, int[] player2) {
        int n = player1.length, score1 = player1[0], score2 = player2[0];
        for (int i = 1; i < n; i++) {
            if (player1[i - 1] == 10) score1 += 2 * player1[i];
            else if (i > 1 && player1[i - 2] == 10) score1 += 2 * player1[i];
            else score1 += player1[i];

            if (player2[i - 1] == 10) score2 += 2 * player2[i];
            else if (i > 1 && player2[i - 2] == 10) score2 += 2 * player2[i];
            else score2 += player2[i];
        }

        if (score1 > score2) return 1;
        else if (score1 < score2) return 2;
        else return 0;
    }

}
