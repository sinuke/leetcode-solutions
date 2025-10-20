package com.sinuke.medium;

public class DesignLinkedList {

    public static class MyLinkedList {

        private Node head;
        private Node tail;
        private int size;

        public MyLinkedList() {

        }

        public int get(int index) {
            if (index > size - 1) return -1;
            return find(index).val;
        }

        public void addAtHead(int val) {
            Node node = new Node(val, null, head);
            if (head != null) head.prev = node;
            head = node;
            size++;
            if (size == 1) tail = head;
        }

        public void addAtTail(int val) {
            Node node = new Node(val, tail, null);
            if (tail != null) tail.next = node;
            tail = node;
            size++;
            if (size == 1) head = tail;
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) addAtHead(val);
            else if (index < size) {
                Node cur = find(index);
                Node node = new Node(val, cur.prev, cur);
                cur.prev = node;
                node.prev.next = node;
                size++;
            } if (index == size) addAtTail(val);
        }

        public void deleteAtIndex(int index) {
            if (index >= size) return;
            Node node = find(index);
            Node prev = node.prev;
            Node next = node.next;

            if (index == 0) {
                head = next;
                if (head != null) head.prev = null;
            } else if (index == size - 1) {
                tail = prev;
                if (tail != null) tail.next = null;
            } else {
                prev.next = next;
                next.prev = prev;
            }

            size--;
            if (size == 0) {
                head = null;
                tail = null;
            } else if (size == 1) head = tail;
        }

        private Node find(int index) {
            int i = 0;
            int delta = 1;
            Node current = head;

            if (index > (size - 1) / 2) {
                i = size - 1;
                delta = -1;
                current = tail;
            }

            while (i != index) {
                current = delta == 1 ? current.next : current.prev;
                i += delta;
            }

            return current;
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
