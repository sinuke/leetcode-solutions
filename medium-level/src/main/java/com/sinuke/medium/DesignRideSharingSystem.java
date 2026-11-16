package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;

public class DesignRideSharingSystem {

    public static class RideSharingSystem {

        private final ItemQueue riders;
        private final ItemQueue drivers;
        private final Map<Integer, Item> ridersMap;
        private final Map<Integer, Item> driversMap;

        public RideSharingSystem() {
            this.riders = new ItemQueue();
            this.drivers = new ItemQueue();
            this.ridersMap = new HashMap<>();
            this.driversMap = new HashMap<>();
        }

        public void addRider(int riderId) {
            var r = new Item(riderId);
            ridersMap.put(riderId, r);
            riders.add(r);
        }

        public void addDriver(int driverId) {
            var d = new Item(driverId);
            driversMap.put(driverId, d);
            drivers.add(d);
        }

        public int[] matchDriverWithRider() {
            var d = drivers.poll();
            var r = riders.poll();

            return (d == null || r == null) ? new int[] {-1, -1} : new int[] {d.id, r.id};
        }

        public void cancelRider(int riderId) {
            if (ridersMap.containsKey(riderId)) {
                riders.remove(ridersMap.get(riderId));
                ridersMap.remove(riderId);
            }
        }

        private static class Item {
            int id;
            Item next;
            Item prev;

            public Item(int id) {
                this.id = id;
            }
        }

        private static class ItemQueue {

            private Item head;
            private Item tail;

            public void add(Item item) {
                if (head == null) {
                    head = item;
                    tail = item;
                } else {
                    tail.next = item;
                    item.prev = tail;
                    tail = item;
                }
            }

            public Item poll() {
                if (head == null) return null;

                Item result = head;
                head = head.next;

                if (head != null) head.prev = null;
                else tail = null;

                result.next = null;
                return result;
            }

            public void remove(Item item) {
                if (item == null || head == null || (item != head && item.prev == null)) return;

                if (item == head) head = head.next;
                else item.prev.next = item.next;

                if (item == tail) tail = item.prev;
                else item.next.prev = item.prev;

                item.prev = null;
                item.next = null;
            }

        }

    }

}
