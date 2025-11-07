package com.sinuke.easy;

public class CountTestedDevicesAfterTestOperations {

    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;
        for (int battery : batteryPercentages) {
            if (battery > count) count++;
        }

        return count;
    }

}
