package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class DesignNumberContainerSystem {

    public static class NumberContainers {

        private final Map<Integer, Integer> indx;
        private final Map<Integer, SortedSet<Integer>> numbers;

        public NumberContainers() {
            indx = new HashMap<>();
            numbers = new HashMap<>();
        }

        public void change(int index, int number) {
            if (indx.containsKey(index)) {
                int old = indx.get(index);
                indx.replace(index, number);
                numbers.get(old).remove(index);
            } else indx.put(index, number);

            numbers.putIfAbsent(number, new TreeSet<>());
            numbers.get(number).add(index);
        }

        public int find(int number) {
            return !numbers.containsKey(number) || numbers.get(number).isEmpty() ? -1 : numbers.get(number).first();
        }
    }

}
