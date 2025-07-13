package com.sinuke.easy;

public class DesignHashMap {

    public static class MyHashMap {

        private final int[] map;
        private final boolean[] flags;

        public MyHashMap() {
            map = new int[1_000_001];
            flags = new boolean[1_000_001];
        }

        public void put(int key, int value) {
            map[key] = value;
            flags[key] = true;
        }

        public int get(int key) {
            return flags[key] ? map[key] : -1;
        }

        public void remove(int key) {
            flags[key] = false;
        }
    }

}
