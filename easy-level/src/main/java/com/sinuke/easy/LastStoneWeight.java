package com.sinuke.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) pq.add(stone);

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            if (x != y) pq.add(x - y);
        }

        return pq.size() == 1 ? pq.poll() : 0;
    }

}
