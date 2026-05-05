package com.sinuke.easy;

public class EarliestFinishTimeForLandAndWaterRidesI {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            int landEnd = landStartTime[i] + landDuration[i];
            for (int j = 0; j < waterStartTime.length; j++) {
                int waterEnd = waterStartTime[j] + waterDuration[j];
                int finish1 = Math.max(landEnd, waterStartTime[j]) + waterDuration[j];
                int finish2 = Math.max(waterEnd, landStartTime[i]) + landDuration[i];
                result = Math.min(result, Math.min(finish1, finish2));
            }
        }
        return result;
    }

}
