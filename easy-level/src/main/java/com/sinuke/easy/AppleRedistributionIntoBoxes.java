package com.sinuke.easy;

import java.util.Arrays;

public class AppleRedistributionIntoBoxes {

    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int cnt = 1, m = capacity.length - 1;

        for (int appl : apple) {
            while (appl > capacity[m] && m > 0) {
                appl -= capacity[m--];
                cnt++;
            }
            capacity[m] -= appl;
        }

        return cnt;
    }

}
