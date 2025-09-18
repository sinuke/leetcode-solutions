package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem {

    public static class UndergroundSystem {

        private final Map<Integer, Station> customers;
        private final Map<Route, Statistics> statistics;

        public UndergroundSystem() {
            this.customers = new HashMap<>(10_000);
            this.statistics = new HashMap<>(20_000);
        }

        public void checkIn(int id, String stationName, int t) {
            customers.put(id, new Station(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            var checkInStation = customers.remove(id);
            var route = new Route(checkInStation.name, stationName);
            statistics.putIfAbsent(route, new Statistics());
            var stat = statistics.get(route);
            stat.sum += (t - checkInStation.time);
            stat.count++;
        }

        public double getAverageTime(String startStation, String endStation) {
            var stat = statistics.get(new Route(startStation, endStation));
            return stat.sum / stat.count;
        }

        private record Station(String name, int time) {}

        private record Route(String start, String end) {}

        private static class Statistics {
            double sum;
            int count;
        }
    }

}
