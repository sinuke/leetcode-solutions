package com.sinuke.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

    public static class TimeMap {

        private final Map<String, List<Value>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new Value(timestamp, value));
        }

        public String get(String key, int timestamp) {
            String result = "";
            if (!map.containsKey(key)) return result;

            List<Value> list = map.get(key);
            if (list.getFirst().timestamp > timestamp) return result;

            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                var item = list.get(mid);
                if (item.timestamp == timestamp) return item.value;
                else if (item.timestamp > timestamp) right = mid - 1;
                else {
                    result = item.value;
                    left = mid + 1;
                }
            }

            return result;
        }

        private record Value(int timestamp, String value) {}
    }

}
