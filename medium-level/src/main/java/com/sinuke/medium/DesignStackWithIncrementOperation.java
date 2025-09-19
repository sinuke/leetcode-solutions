package com.sinuke.medium;

public class DesignStackWithIncrementOperation {

    public static class CustomStack {

        private final int[] values;
        private int index;

        public CustomStack(int maxSize) {
            this.values = new int[maxSize];
            this.index = -1;
        }

        public void push(int x) {
            if (index < values.length - 1) values[++index] = x;
        }

        public int pop() {
            return index == -1 ? -1 : values[index--];
        }

        public void increment(int k, int val) {
            for (int i = 0; i < Math.min(k, index + 1); i++) {
                values[i] += val;
            }
        }
    }

}
