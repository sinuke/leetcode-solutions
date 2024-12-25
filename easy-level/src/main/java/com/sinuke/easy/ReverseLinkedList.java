package com.sinuke.easy;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        var current = head;
        while (current.next != null) {
            var next = current.next;
            current.next = next.next;
            next.next = head;
            head = next;
        }
        
        return head;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) return null;
        return recursive(null, head);
    }
    
    private ListNode recursive(ListNode previous, ListNode current) {
        if (current.next == null) {
            current.next = previous;
            return current;
        }
        
        var next = current.next;
        current.next = previous;
        
        return recursive(current, next);
    }
    
    public static class ListNode {
        int val;
        ListNode next;
    
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
}
