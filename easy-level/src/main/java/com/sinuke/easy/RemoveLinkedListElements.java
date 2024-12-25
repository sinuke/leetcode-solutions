package com.sinuke.easy;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode result = new ListNode();
        var curr = result;
        var node = head;

        while (node != null) {
            if (node.val != val) {
                curr.next  = new ListNode(node.val);
                curr = curr.next;
            }

            node = node.next;
        }

        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
