package com.sinuke.easy;

public class EarliestTimeToFinishOneTask {

    public int earliestTime(int[][] tasks) {
        int min = Integer.MAX_VALUE;
        for (int[] task : tasks) {
            min = Math.min(task[0] + task[1], min);
        }
        return min;
    }

}
