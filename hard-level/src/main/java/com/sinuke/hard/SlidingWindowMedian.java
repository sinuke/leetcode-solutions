package com.sinuke.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        int start = 0, end = 0;
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(indx -> nums[indx]));

        int i = 0;
        while (end < nums.length) {
            int len = end - start + 1;
            if (!pq.isEmpty() && len < k) {
                // remove
            }

            pq.add(nums[end]);

            if (len == k) start++;
            end++;


//            int len = end - start + 1;
//            PriorityQueue<Integer> pq = new PriorityQueue<>();
//            int j = 0;
//            while (j < len) pq.offer(start + j++);
//            int middle = (end - start) / 2;
//            j = 0;
//            while (j < middle) {
//                pq.poll();
//                j++;
//            }
//
//            double val = pq.poll();
//            if (len % 2 == 0) val = (val + pq.poll()) / 2;
//            result[i++] = val;
//
//            end++;
//            start++;
        }
        return result;
    }

}
