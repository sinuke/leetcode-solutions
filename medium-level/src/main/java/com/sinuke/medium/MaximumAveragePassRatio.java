package com.sinuke.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumAveragePassRatio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<Double[]> pq = new PriorityQueue<>(classes.length, Comparator.comparing((Double[] o) -> o[3]).reversed());

        double sum = 0.0;
        for (int[] cls : classes) {
            Double[] ext_class = new Double[4];
            ext_class[0] = (double) cls[0];
            ext_class[1] = (double) cls[1];
            ext_class[2] = ext_class[0] / ext_class[1];
            ext_class[3] = (ext_class[0] + 1) / (ext_class[1] + 1) - ext_class[2];
            sum += ext_class[2];
            pq.add(ext_class);
        }

        int k = extraStudents;
        while (k > 0) {
            var cls = pq.poll();
            sum -= cls[2];
            cls[0]++;
            cls[1]++;
            cls[2] = cls[0] / cls[1];
            cls[3] = (cls[0] + 1) / (cls[1] + 1) - cls[2];
            pq.add(cls);
            sum += cls[2];
            k--;
        }

        return sum / classes.length;
    }

}
