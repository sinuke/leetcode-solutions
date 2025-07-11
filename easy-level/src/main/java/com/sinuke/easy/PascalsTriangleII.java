package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = List.of(1);

        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }

            row.add(1);
            prev = row;
        }

        return prev;
    }

}
