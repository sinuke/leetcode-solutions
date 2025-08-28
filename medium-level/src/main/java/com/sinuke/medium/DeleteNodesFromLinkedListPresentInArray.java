package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentInArray {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) set.add(num);

        ListNode result = head, parent = null;
        while (head != null) {
            if (set.contains(head.val)) {
                if (parent != null) parent.next = head.next;
                else result = head.next;
            } else parent = head;
            head = head.next;
        }

        return result;
    }

}
