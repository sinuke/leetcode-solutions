package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pt = new ArrayList<>(numRows);

        pt.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(pt.get(i - 1).get(j - 1) + pt.get(i - 1).get(j));
            }

            row.add(1);
            pt.add(row);

        }

        return pt;
    }

}
