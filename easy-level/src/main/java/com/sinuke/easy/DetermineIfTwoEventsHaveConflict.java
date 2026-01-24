package com.sinuke.easy;

public class DetermineIfTwoEventsHaveConflict {

    public boolean haveConflict(String[] event1, String[] event2) {
        int e1s = toMinutes(event1[0]);
        int e1e = toMinutes(event1[1]);
        int e2s = toMinutes(event2[0]);
        int e2e = toMinutes(event2[1]);

        return e1e >= e2s || e2e <= e1s;
        //return (e1s <= e2s && e1e >= e2s) || (e2s <= e1s && e2e >= e1s);
    }

    private int toMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }

}
