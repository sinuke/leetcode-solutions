package com.sinuke;

public class ImplementStackUsingQueues {

    public static class MyStack {

        private final int[] stack;
        private int count;

        public MyStack() {
            stack = new int[100];
            count = 0;
        }

        public void push(int x) {
            stack[count] = x;
            count++;
        }

        public int pop() {
            return stack[--count];
        }

        public int top() {
            return stack[count - 1];
        }

        public boolean empty() {
            return count == 0;
        }

    }

}
