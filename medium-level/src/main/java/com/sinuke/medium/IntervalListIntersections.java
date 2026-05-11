package com.sinuke.medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int f = 0, s = 0;
        while (f < firstList.length && s < secondList.length) {
            int l = Math.max(firstList[f][0], secondList[s][0]);
            int r = Math.min(firstList[f][1], secondList[s][1]);
            if (l <= r) res.add(new int[] {l, r});

            if (firstList[f][1] <= secondList[s][1]) f++;
            else if (secondList[s][1] <= firstList[f][1]) s++;
            else {
                f++;
                s++;
            }
        }
        return res.toArray(new int[0][0]);
    }

}
