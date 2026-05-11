package com.sinuke.easy;

public class ScoreValidator {

    public int[] scoreValidator(String[] events) {
        int score = 0, counter = 0;
        for (String event : events) {
            switch (event) {
                case "0", "1", "2", "3", "4", "6" -> score += Integer.parseInt(event);
                case "W" -> counter++;
                default -> score++;
            }
            if (counter == 10) break;
        }
        return new int[] {score, counter};
    }

}
