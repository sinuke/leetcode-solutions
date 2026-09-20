package com.sinuke.easy;

public class FindTheWinningPlayerInCoinGame {

    public String winningPlayer(int x, int y) {
        int turns = Math.min(x, y / 4);
        return turns % 2 == 0 ? "Bob" : "Alice";
    }

}
