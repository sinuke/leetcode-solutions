package com.sinuke.easy;

import java.util.Comparator;
import java.util.List;

public class PointsThatIntersectWithCars {

    public int numberOfPoints(List<List<Integer>> nums) {
        nums.sort(Comparator.comparingInt(List::getFirst));
        int cnt = 0, start = -1, end = -1;
        for (List<Integer> p : nums) {
            if (start == -1 || end == -1) {
                start = p.get(0);
                end = p.get(1);
            } else if (end < p.get(0)) {
                cnt += end - start + 1;
                start = p.get(0);
                end = p.get(1);
            } else end = Math.max(end, p.get(1));
        }

        return cnt + end - start + 1;
    }

}
