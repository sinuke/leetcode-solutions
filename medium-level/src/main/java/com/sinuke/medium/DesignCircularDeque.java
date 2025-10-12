package com.sinuke.medium;

public class DesignCircularDeque {

    public static class MyCircularDeque {

        private Node head;
        private Node last;
        private int size;
        private final int maxSize;

        public MyCircularDeque(int k) {
            this.maxSize = k;
            this.size = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;

            Node node = new Node(value, null, head);
            if (head != null) head.prev = node;
            head = node;
            size++;
            if (size == 1) last = head;

            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;

            Node node = new Node(value, last, null);
            if (last != null) last.next = node;
            last = node;
            size++;
            if (size == 1) head = last;

            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;

            Node node = head.next;
            head.next = null;
            if (node != null) node.prev = null;
            head = node;
            size--;

            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;

            Node node = last.prev;
            last.prev = null;
            if (node != null) node.next = null;
            last = node;
            size--;

            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : head.val;
        }

        public int getRear() {
            return isEmpty() ? -1 : last.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == maxSize;
        }

        private static class Node {
            int val;
            Node next;
            Node prev;

            Node(int val, Node prev, Node next) {
                this.val = val;
                this.prev = prev;
                this.next = next;
            }
        }
    }

}
