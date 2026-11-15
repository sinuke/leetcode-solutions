package com.sinuke.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignEventManager {

    public static class EventManager {

        private final TreeSet<Event> ts;
        private final Map<Integer, Event> map;

        public EventManager(int[][] events) {
            this.ts = new TreeSet<>(Comparator.<Event>comparingInt(e -> e.pr).thenComparingInt(e -> - e.id));
            this.map = new HashMap<>();

            for (int[] event : events) {
                var ev = new Event(event[0], event[1]);
                map.put(event[0], ev);
                ts.add(ev);
            }
        }

        public void updatePriority(int eventId, int newPriority) {
            var ev = map.get(eventId);
            ts.remove(ev);
            ev.pr = newPriority;
            ts.add(ev);
        }

        public int pollHighest() {
            if (ts.isEmpty()) return -1;

            var ev = ts.pollLast();
            map.remove(ev.id);
            return ev.id;
        }

        private static class Event {
            int id;
            int pr;

            Event(int id, int pr) {
                this.id = id;
                this.pr = pr;
            }
        }

    }

}
