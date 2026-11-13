package com.sinuke.medium;

import java.util.*;

public class DesignInsertDeleteGetRandomO1 {

    public static class RandomizedSet {

        private final Random rand;
        private final Map<Integer, Integer> map;
        private final List<Integer> lst;

        public RandomizedSet() {
            rand = new Random();
            map = new HashMap<>(100_000);
            lst = new ArrayList<>(100_000);
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;

            lst.add(val);
            map.put(val, lst.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int i = map.get(val);
            map.remove(val);

            if (lst.size() > 1) {
                int v = lst.getLast();
                lst.set(i, v);
                map.replace(v, i);
            }
            lst.removeLast();

            return true;
        }

        public int getRandom() {
            return lst.get(rand.nextInt(lst.size()));
        }
    }

}
