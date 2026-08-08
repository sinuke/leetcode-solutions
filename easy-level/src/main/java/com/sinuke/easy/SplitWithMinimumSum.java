package com.sinuke.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplitWithMinimumSum {

    public int splitNum(int num) {
        List<Integer> l = new ArrayList<>(11);
        while (num > 0) {
            l.add(num % 10);
            num /= 10;
        }

        Collections.sort(l);

        int d1 = 0, d2 = 0, i = 0;
        while (i < l.size()) {
            d1 = d1 * 10 + l.get(i++);
            if (i < l.size()) d2 = d2 * 10 + l.get(i++);
        }
        return d1 + d2;
    }

}