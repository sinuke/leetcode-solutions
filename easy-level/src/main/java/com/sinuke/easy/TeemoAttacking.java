package com.sinuke.easy;

public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            count += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return count + duration;
    }
    
}
