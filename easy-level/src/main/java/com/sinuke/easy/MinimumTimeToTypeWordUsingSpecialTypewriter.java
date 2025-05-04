package com.sinuke.easy;

public class MinimumTimeToTypeWordUsingSpecialTypewriter {

    public int minTimeToType(String word) {
        int seconds = 0, position = 0;
        for (char c : word.toCharArray()) {
            int destination = c - 'a';

            int dist1 = Math.abs(destination - position);
            int dist2 = 26 - dist1;

            seconds += Math.min(dist1, dist2);
            position = destination;
        }
        return seconds + word.length();
    }

}
