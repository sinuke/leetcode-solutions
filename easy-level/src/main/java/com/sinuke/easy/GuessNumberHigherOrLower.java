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
        int low = 0, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int guess = guess(mid);

            if (guess == 0) return mid;
            else if (guess == 1) low = mid + 1;
            else if (guess == -1) high = mid;
        }

        return n;
    }

}
