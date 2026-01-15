package com.sinuke.easy;

public class BestPokerHand {

    public String bestHand(int[] ranks, char[] suits) {
        String best = "High Card";

        // "Flush" check
        char prev = suits[0];
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != prev) break;
            else if (i == 4) return "Flush";
            else prev = suits[i];
        }

        // "Pair" or "Three of a Kind" check
        int[] freq = new int[14];
        for (int r : ranks) {
            freq[r]++;
            if (freq[r] == 2) best = "Pair";
            else if (freq[r] == 3) return "Three of a Kind";
        }

        return best;
    }

}
