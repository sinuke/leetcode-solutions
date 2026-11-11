package com.sinuke.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DesignLRUCache {

    public static class LRUCache {

        private final Map<Integer, Node> map;
        private final LinkedList<Node> lst;
        private final int capacity;

        public LRUCache(int capacity) {
            this.map = new HashMap<>(capacity + 1);
            this.lst = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;

            var node = map.get(key);
            lst.remove(node);
            lst.addFirst(node);

            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                var node = map.get(key);
                node.val = value;
                lst.remove(node);
                lst.addFirst(node);
            } else {
                var node = new Node(key, value);
                lst.addFirst(node);
                map.put(key, node);
            }

            if (map.size() > capacity) {
                var node = lst.removeLast();
                map.remove(node.key);
            }
        }

        private static class Node {
            int key;
            int val;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

    }

}
