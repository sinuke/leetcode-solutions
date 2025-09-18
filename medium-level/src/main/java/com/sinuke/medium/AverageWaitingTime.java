package com.sinuke.medium;

public class AverageWaitingTime {

    public double averageWaitingTime(int[][] customers) {
        double total = customers[0][1];
        customers[0][1] = customers[0][0] + customers[0][1];

        for (int i = 1; i < customers.length; i++) {
            total += customers[i][1];
            if (customers[i - 1][1] > customers[i][0]) {
                total += customers[i - 1][1] - customers[i][0];
                customers[i][1] = customers[i - 1][1] + customers[i][1];
            } else customers[i][1] = customers[i][0] + customers[i][1];
        }

        return total / customers.length;
    }

}
