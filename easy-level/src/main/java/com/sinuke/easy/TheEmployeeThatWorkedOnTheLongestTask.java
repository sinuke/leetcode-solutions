package com.sinuke.easy;

public class TheEmployeeThatWorkedOnTheLongestTask {

    public int hardestWorker(int n, int[][] logs) {
        int emp = logs[0][0], time = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int interval = logs[i][1] - logs[i - 1][1];
            if (interval > time) {
                emp = logs[i][0];
                time = interval;
            } else if (interval == time) emp = Math.min(emp, logs[i][0]);
        }
        return emp;
    }

}
