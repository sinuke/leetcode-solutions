package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        var current = head;
        while (current != null) {
            if (current.next != null && set.contains(current.next)) return true;

            set.add(current.next);
            current = current.next;
        }

        return false;
    }

    public boolean hasCycleTwoPointers(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }

        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }

    }

}
