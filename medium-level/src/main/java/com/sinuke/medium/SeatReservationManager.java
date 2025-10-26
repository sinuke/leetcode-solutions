package com.sinuke.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SeatReservationManager {

    public static class SeatManager {

        private final PriorityQueue<Integer> pq;

        public SeatManager(int n) {
            List<Integer> list = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) list.add(i);

            pq = new PriorityQueue<>(list);
        }

        public int reserve() {
            return pq.poll();
        }

        public void unreserve(int seatNumber) {
            pq.offer(seatNumber);
        }
    }

}
