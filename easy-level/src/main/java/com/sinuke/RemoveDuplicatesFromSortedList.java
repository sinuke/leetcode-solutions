package com.sinuke;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        var result = head == null ? null : new ListNode(head.val);
        var curr = result;

        while (head != null) {
            if (curr.val != head.val) {
                curr.next = new ListNode(head.val);
                curr = curr.next;
            }

            head = head.next;
        }

        return result;
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
