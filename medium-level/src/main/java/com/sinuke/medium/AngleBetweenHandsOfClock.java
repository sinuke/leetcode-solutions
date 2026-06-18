package com.sinuke.medium;

public class AngleBetweenHandsOfClock {

    public double angleClock(int hour, int minutes) {
        if (hour == 12) hour = 0;
        double mangle = 6 * minutes;
        double hangle = (((double) minutes / 60) + hour) * 30;

        double a1 = Math.abs(hangle - mangle);
        double a2 = Math.abs(360 - mangle + hangle);
        double a3 = Math.abs(360 - hangle + mangle);
        return Math.min(a1, Math.min(a2, a3));
    }

}
