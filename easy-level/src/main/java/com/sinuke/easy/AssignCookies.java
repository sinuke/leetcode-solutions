package com.sinuke.easy;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0, count = 0;
        while (i < g.length && j < s.length) {
            while (j < s.length && s[j] < g[i]) j++;
            if (j < s.length && s[j] >= g[i]) {
                count++;
                j++;
            }
            i++;
        }

        return count;
    }

}
