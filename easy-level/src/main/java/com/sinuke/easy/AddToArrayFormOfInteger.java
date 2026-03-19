package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>(num.length + 5);
        int i = num.length - 1, ost = 0;
        while (i >= 0 || k != 0) {
            int d = k % 10 + ost;
            ost = 0;
            if (i >= 0) d += num[i--];

            ost = d / 10;
            if (ost > 0) d -= 10;

            result.addFirst(d);
            k /= 10;
        }

        if (ost != 0) result.addFirst(ost);

        return result;
    }

}
