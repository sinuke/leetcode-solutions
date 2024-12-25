package com.sinuke.easy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class TakeGiftsFromRichestPile {

    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i : gifts) {
            pq.add(i);
            sum += i;
        }

        int i = 0;
        while (i < k) {
            int value = pq.poll();
            sum -= value;
            int sqrt = (int) Math.sqrt(value);
            sum += sqrt;

            pq.add(sqrt);
            i++;
        }

        return sum;
    }

}
