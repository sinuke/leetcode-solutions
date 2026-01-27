package com.sinuke.easy;

public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char result = keysPressed.charAt(0);
        int duration = releaseTimes[0];

        for (int i = 1; i < releaseTimes.length; i++) {
            int d = releaseTimes[i] - releaseTimes[i - 1];
            char c = keysPressed.charAt(i);

            if (d > duration) {
                result = c;
                duration = d;
            } else if (d == duration && c > result) result = c;
        }

        return result;
    }

}
