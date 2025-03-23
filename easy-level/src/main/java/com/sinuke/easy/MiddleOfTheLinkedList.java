package com.sinuke.easy;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        var slow = head;
        var fast = head.next;

        while (fast != null) {
            if (fast.next == null) return slow.next == null ? slow : slow.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

}
