package com.sinuke.hard;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumInitialEnergyToFinishTasks {

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, Comparator.<int[]>comparingInt(a -> a[1] - a[0]).reversed());
        int req = tasks[0][1], act = tasks[0][0];
        for (int i = 1; i < tasks.length; i++) {
            req += (req - act >= tasks[i][1]) ? 0 : tasks[i][1] - req + act;
            act += tasks[i][0];
        }
        return req;
    }

}
