package com.sinuke.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(getD(p1, p2));
        set.add(getD(p1, p3));
        set.add(getD(p1, p4));

        set.add(getD(p2, p1));
        set.add(getD(p2, p3));
        set.add(getD(p2, p4));

        set.add(getD(p3, p1));
        set.add(getD(p3, p2));
        set.add(getD(p3, p4));

        set.add(getD(p4, p1));
        set.add(getD(p4, p2));
        set.add(getD(p4, p3));

        return set.size() == 2 && !set.contains(0);
    }

    private int getD(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

}
