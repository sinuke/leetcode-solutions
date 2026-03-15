package com.sinuke.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TheKWeakestRowsInMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Row> rows = new ArrayList<>(mat.length);
        for (int row = 0; row < mat.length; row++) {
            var r = new Row();
            r.index = row;
            for (int column = 0; column < mat[row].length; column++) r.score += mat[row][column];
            rows.add(r);
        }

        return rows.stream()
                .sorted(Comparator.<Row>comparingInt(r -> r.score).thenComparing(r -> r.index))
                .limit(k)
                .mapToInt(r -> r.index)
                .toArray();
    }

    private static class Row {
        int index;
        int score;
    }

}
