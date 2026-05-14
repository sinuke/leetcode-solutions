package com.sinuke.medium;

import java.util.ArrayList;
import java.util.List;

public class FindPositiveIntegerSolutionForGivenEquation {

    public interface CustomFunction {
        int f(int x, int y);
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            int l = 1, r = 1000;
            while (l <= r) {
                int y = (r + l) / 2;
                int f = customfunction.f(x, y);
                if (f == z) {
                    result.add(List.of(x, y));
                    break;
                } else if (f < z) l = y + 1;
                else r = y - 1;
            }
        }
        return result;
    }

}
