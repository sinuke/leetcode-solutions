package com.sinuke.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathCrossing {

    public boolean isPathCrossing(String path) {
        Set<List<Integer>> points = new HashSet<>();
        int x = 0, y = 0;
        points.add(List.of(x, y));

        for (char c : path.toCharArray()) {
            if (c == 'N') y -= 1;
            else if (c == 'S') y += 1;
            else if (c == 'W') x += 1;
            else x -= 1;
            List<Integer> point = List.of(x, y);
            if (points.contains(point)) return true;
            points.add(point);
        }

        return false;
    }

}
