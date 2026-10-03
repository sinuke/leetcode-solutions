package com.sinuke.easy;

public class AlternatingGroupsI {

    public int numberOfAlternatingGroups(int[] colors) {
        int cnt = 0;
        for (int i = 0; i < colors.length; i++) {
            if (i == 0 && colors[i] != colors[i + 1] && colors[i] != colors[colors.length - 1]) cnt++;
            else if (i == colors.length - 1 && colors[i] != colors[i - 1] && colors[i] != colors[0]) cnt++;
            else if (i > 0 && i < colors.length - 1 && colors[i] != colors[i - 1] && colors[i] != colors[i + 1]) cnt++;
        }
        return cnt;
    }

}
