package com.sinuke.easy;

public class ImplementQueueUsingStacks {

    public static class MyQueue {

        private final int[] stack;
        private int count;
        private int start;

        public MyQueue() {
            stack = new int[100];
            count = 0;
            start = 0;
        }

        public void push(int x) {
            stack[start + count] = x;
            count++;
        }

        public int pop() {
            count--;
            start++;
            return stack[start - 1];
        }

        public int peek() {
            return stack[start];
        }

        public boolean empty() {
            return count == 0;
        }

    }

}
