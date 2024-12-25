package com.sinuke.easy;

public class GuessNumberHigherOrLower {

    private final int pick;

    public GuessNumberHigherOrLower(int pick) {
        this.pick = pick;
    }

    private int guess(int n) {
        if (n < pick) return 1;
        else if (n > pick) return -1;

        return 0;
    }

    public int guessNumber(int n) {
        int res = guess(n);

        if (res == 1) return guessNumber(n + n / 2);
        else if (res == -1) return guessNumber(n / 2);
        else return n;
    }

}
