package com.sinuke.medium;

import java.util.LinkedList;
import java.util.Queue;

public class IteratorForCombination {

    public static class CombinationIterator {

        private final Queue<String> comb;
        private int index;

        public CombinationIterator(String characters, int combinationLength) {
            comb = new LinkedList<>();
            generate(characters.toCharArray(), combinationLength, 0, new StringBuilder(), comb);
        }

        public String next() {
            return comb.poll();
        }

        public boolean hasNext() {
            return !comb.isEmpty();
        }

        private void generate(char[] chars, int length, int start, StringBuilder sb, Queue<String> result) {
            if (sb.length() == length) {
                result.add(sb.toString());
                return;
            }

            for (int i = start; i < chars.length; i++) {
                sb.append(chars[i]);
                generate(chars, length, i + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
