package com.sinuke.easy;

public class AssignUmbrellaOnRainyDays {

    public String[] assignUmbrella(int[] rain) {
        int acnt = 0, bcnt = 0, j = 0;
        String[] res = new String[rain.length];
        for (int i = 0; i < rain.length; i++) {
            if (rain[i] == 0) res[j++] = "None";
            else {
                if (i < rain.length - 1 && rain[i + 1] == 0) {
                    bcnt++;
                    res[j++] = "Bob";
                } else if (i < rain.length - 1 && rain[i + 1] == 1) {
                    if (acnt <= bcnt) {
                        acnt++;
                        res[j++] = "Alice";
                    } else {
                        bcnt++;
                        res[j++] = "Bob";
                    }
                } else {
                    bcnt++;
                    res[j++] = "Bob";
                }
            }
        }
        return res;
    }

}
