package com.sinuke.medium;

import java.util.HashSet;
import java.util.Set;

public class DesignImplementTriePrefixTree {

    public static class Trie {

        private final Set<String> p;
        private final Set<String> s;

        public Trie() {
            p = new HashSet<>();
            s = new HashSet<>();
        }

        public void insert(String word) {
            s.add(word);
            for (int i = 0; i < word.length() - 1; i++) {
                String k = word.substring(0, i + 1);
                p.add(k);
            }
        }

        public boolean search(String word) {
            return s.contains(word);
        }

        public boolean startsWith(String prefix) {
            return p.contains(prefix) || s.contains(prefix);
        }

    }

}
