package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>(94);
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (i - start >= 3) result.add(List.of(start, i - 1));
                start = i;
            }
        }
        if (start != s.length() - 1 && s.length() - start >= 3) result.add(List.of(start, s.length() - 1));
        return result;
    }

}
