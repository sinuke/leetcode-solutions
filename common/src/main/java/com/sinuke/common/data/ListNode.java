package com.sinuke.common.data;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createList(int... values) {
        if (values.length == 0) return null;

        var head = new ListNode(values[0]);
        var previous = head;
        for (int i = 1; i < values.length; i++) {
            var element = new ListNode(values[i]);
            previous.next = element;
            previous = element;
        }

        return head;
    }

    public static int[] extractValues(ListNode node) {

        int count = 0;
        var first = node;
        while (node != null) {
            count++;
            node = node.next;
        }

        var result = new int[count];
        node = first;
        var index = 0;
        while (node != null) {
            result[index] = node.val;
            node = node.next;
            index++;
        }

        return result;
    }

}
