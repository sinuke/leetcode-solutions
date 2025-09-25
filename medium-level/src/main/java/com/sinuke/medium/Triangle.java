package com.sinuke.medium;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> line = triangle.get(i);
            List<Integer> prev = triangle.get(i - 1);

            for (int j = 0; j < line.size(); j++) {
                if (j == 0) line.set(j, line.get(j) + prev.get(j));
                else if (j == line.size() - 1) line.set(j, line.get(j) + prev.get(j - 1));
                else line.set(j, Math.min(line.get(j) + prev.get(j), line.get(j) + prev.get(j - 1)));

                if (i == triangle.size() - 1) min = Math.min(min, line.get(j));
            }
        }

        return triangle.size() == 1 ? triangle.getFirst().getFirst() : min;
    }

}
