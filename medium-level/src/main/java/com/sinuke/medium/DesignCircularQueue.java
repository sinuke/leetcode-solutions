package com.sinuke.medium;

public class DesignCircularQueue {

    public static class MyCircularQueue {

        private final int maxSize;
        private Node node;
        private int size;

        public MyCircularQueue(int k) {
            this.size = 0;
            this.maxSize = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;

            Node newNode = new Node(value, node, null);
            if (node == null) {
                node = newNode;
                node.next = newNode;
            } else {
                newNode.next = node.next;
                node.next = newNode;
                node = newNode;
            }
            size++;

            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;

            if (size == 1) node = null;
            else if (size == 2) {
                node.next = null;
                node.prev = null;
                node.next = node;
            } else {
                Node newHead = node.next.next;
                newHead.prev = null;
                node.next = newHead;
            }

            size--;

            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : node.next.val;
        }

        public int Rear() {
            return isEmpty() ? -1 : node.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return maxSize == size;
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
