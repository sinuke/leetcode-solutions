package com.sinuke.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class StockPriceFluctuation {

    public static class StockPrice {

        private final TreeSet<Price> set;
        private final Map<Integer, Price> map;
        private Price current;

        public StockPrice() {
            set = new TreeSet<>(Comparator.comparing((Price p) -> p.price).thenComparing((Price p) -> p.timestamp));
            map = new HashMap<>();
        }

        public void update(int timestamp, int price) {
            if (map.containsKey(timestamp)) {
                Price pr = map.get(timestamp);
                set.remove(pr);
                pr.price = price;
                set.add(pr);
            } else {
                Price pr = new Price(timestamp, price);
                set.add(pr);
                map.put(timestamp, pr);
            }

            if (current == null || timestamp >= current.timestamp) {
                current = map.get(timestamp);
            }
        }

        public int current() {
            return current.price;
        }

        public int maximum() {
            return set.last().price;
        }

        public int minimum() {
            return set.first().price;
        }

        private static class Price {
            int timestamp;
            int price;

            Price(int timestamp, int price) {
                this.timestamp = timestamp;
                this.price = price;
            }
        }
    }

}
