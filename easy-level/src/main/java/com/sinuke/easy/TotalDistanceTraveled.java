package com.sinuke.easy;

public class TotalDistanceTraveled {

    public int distanceTraveled(int mainTank, int additionalTank) {
        int m = mainTank, add = 0, i = 1;
        while (m > 4 && additionalTank > 0) {
            m -= 4;
            additionalTank--;
            add++;
        }
        return (mainTank + add) * 10;
    }

}
