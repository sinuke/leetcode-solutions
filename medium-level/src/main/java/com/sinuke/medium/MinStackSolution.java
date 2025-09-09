package com.sinuke.medium;

import java.util.Stack;

public class MinStackSolution {

    public static class MinStack {

        private final Stack<Node> stack;
        private int min;

        public MinStack() {
            this.min = Integer.MAX_VALUE;
            this.stack = new Stack<>();
        }

        public void push(int val) {
            min = Math.min(min, val);
            stack.push(new Node(val, min));
        }

        public void pop() {
            stack.pop();
            min = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek().min;
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return min;
        }

        private static class Node {
            int val;
            int min;

            Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

    }

}
