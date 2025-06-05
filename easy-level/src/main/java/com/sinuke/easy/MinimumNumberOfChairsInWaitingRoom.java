package com.sinuke.easy;

public class MinimumNumberOfChairsInWaitingRoom {

    public int minimumChairs(String s) {
        int max = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') {
                if (count == max) max++;
                count++;
            } else count--;
        }
        return max;
    }

}
