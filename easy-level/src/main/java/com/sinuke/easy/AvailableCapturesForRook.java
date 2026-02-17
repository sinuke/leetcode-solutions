package com.sinuke.easy;

public class AvailableCapturesForRook {

    public int numRookCaptures(char[][] board) {
        int[] rook = findRook(board);
        int l = rook[1] - 1, r = rook[1] + 1, u = rook[0] - 1, d = rook[0] + 1;
        int count = 0;

        // check left
        while (l >= 0) {
            if (board[rook[0]][l] == 'p') {
                count++;
                break;
            } else if (board[rook[0]][l] == 'B') break;
            l--;
        }

        // check right
        while (r < 8) {
            if (board[rook[0]][r] == 'p') {
                count++;
                break;
            } else if (board[rook[0]][r] == 'B') break;
            r++;
        }

        // check up
        while (u >= 0) {
            if (board[u][rook[1]] == 'p') {
                count++;
                break;
            } else if (board[u][rook[1]] == 'B') break;
            u--;
        }

        // check down
        while (d < 8) {
            if (board[d][rook[1]] == 'p') {
                count++;
                break;
            } else if (board[d][rook[1]] == 'B') break;
            d++;
        }

        return count;
    }

    private int[] findRook(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') return new int[]{i, j};
            }
        }
        return new int[] {7, 7};
    }

}
