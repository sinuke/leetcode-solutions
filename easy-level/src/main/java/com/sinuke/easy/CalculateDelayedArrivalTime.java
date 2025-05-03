package com.sinuke.easy;

public class CalculateDelayedArrivalTime {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int result = arrivalTime + delayedTime;
        if (result == 24 || result == 48) return 0;
        else if (result > 24) return result - 24;
        return result;
    }

}
