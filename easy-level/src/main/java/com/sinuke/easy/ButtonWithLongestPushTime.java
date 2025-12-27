package com.sinuke.easy;

public class ButtonWithLongestPushTime {

    public int buttonWithLongestTime(int[][] events) {
        int index = 0, t = events[index][1], duration = t;
        for (int i = 1; i < events.length; i++) {
            if (events[i][1] - t > duration || (events[i][1] - t == duration && events[i][0] < events[index][0])) {
                index = i;
                duration = events[i][1] - t;
            }
            t = events[i][1];
        }
        return events[index][0];
    }

}
