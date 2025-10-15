package com.sinuke.medium;

import java.util.Deque;
import java.util.LinkedList;

public class DesignFrontMiddleBackQueue {

    public static class FrontMiddleBackQueue {

        private final Deque<Integer> left;
        private final Deque<Integer> right;
        private int size;

        public FrontMiddleBackQueue() {
            this.left = new LinkedList<>();
            this.right = new LinkedList<>();
            size = 0;
        }

        public void pushFront(int val) {
            left.offerFirst(val);
            size++;
            if (size % 2 == 0) right.offerFirst(left.pollLast());
        }

        public void pushMiddle(int val) {
            if (size % 2 != 0) right.offerFirst(left.pollLast());
            left.offerLast(val);
            size++;
        }

        public void pushBack(int val) {
            right.offerLast(val);
            size++;
            if (size % 2 != 0) left.offerLast(right.pollFirst());
        }

        public int popFront() {
            if (size == 0) return -1;
            int val = left.pollFirst();
            size--;
            if (size % 2 != 0) left.offerLast(right.pollFirst());
            return val;
        }

        public int popMiddle() {
            if (size == 0) return -1;
            int val = left.pollLast();
            size--;
            if (size % 2 != 0) left.offerLast(right.pollFirst());
            return val;
        }

        public int popBack() {
            if (size == 0) return -1;
            int val = size == 1 ? left.pollFirst() : right.pollLast();
            size--;
            if (size != 0 && size % 2 == 0) right.offerFirst(left.pollLast());
            return val;
        }
    }

}
