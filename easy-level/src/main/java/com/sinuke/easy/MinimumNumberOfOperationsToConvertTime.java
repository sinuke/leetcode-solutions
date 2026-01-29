package com.sinuke.easy;

public class MinimumNumberOfOperationsToConvertTime {

    public int convertTime(String current, String correct) {
        int cur = toMinutes(current), cor = toMinutes(correct), ans = 0;
        while (cur < cor) {
            if (cor - cur >= 60) cur += 60;
            else if (cor - cur >= 15) cur += 15;
            else if (cor - cur >= 5) cur += 5;
            else cur += 1;

            ans++;
        }
        return ans;
    }

    private int toMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }

}
