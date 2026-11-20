package com.sinuke.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DesignImplementRouter {

    public static class Router {

        private final int limit;
        private final Deque<Packet> queue;
        private final Set<Packet> set;
        private final Map<Integer, Timeline> map;

        public Router(int memoryLimit) {
            this.limit = memoryLimit;
            this.queue = new LinkedList<>();
            this.set = new HashSet<>();
            this.map = new HashMap<>();
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            var p = new Packet(source, destination, timestamp);
            if (set.contains(p)) return false;
            if (queue.size() == limit) remove();

            set.add(p);
            queue.add(p);
            map.computeIfAbsent(destination, _ -> new Timeline()).lst.add(timestamp);
            return true;
        }

        public int[] forwardPacket() {
            if (queue.isEmpty()) return new int[] {};
            var p = remove();
            return new int[] {p.s, p.d, p.t};
        }

        public int getCount(int destination, int startTime, int endTime) {
            var tl = map.get(destination);
            if (tl == null) return 0;
            return lowerBound(tl, endTime + 1) - lowerBound(tl, startTime);
        }

        private Packet remove() {
            var p = queue.poll();
            set.remove(p);
            map.get(p.d).indx++;
            return p;
        }

        private int lowerBound(Timeline tl, int target) {
            int l = tl.indx, r = tl.lst.size();
            while (l < r) {
                int m = (l + r) >>> 1;
                if (tl.lst.get(m) >= target) r = m;
                else l = m + 1;
            }
            return l;
        }

        private record Packet(int s, int d, int t) {}

        private static class Timeline {
            int indx = 0;
            List<Integer> lst = new ArrayList<>();
        }

    }

}
