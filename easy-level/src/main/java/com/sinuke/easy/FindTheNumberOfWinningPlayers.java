package com.sinuke.easy;

public class FindTheNumberOfWinningPlayers {

    // 1 ms
    public int winningPlayerCount2(int n, int[][] pick) {
        int[][] players = new int[n][11];

        for (int i = 0; i < pick.length; i++) players[pick[i][0]][pick[i][1]]++;

        int count = 0;
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (players[i][j] > i) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    // 1 ms
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] players = new int[n][12];
        int count = 0;
        for (int i = 0; i < pick.length; i++) {
            players[pick[i][0]][pick[i][1]]++;
            if (players[pick[i][0]][pick[i][1]] > pick[i][0] && players[pick[i][0]][11] == 0) {
                players[pick[i][0]][11] = 1;
                count++;
            }
        }

        return count;
    }

}
