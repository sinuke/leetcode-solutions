package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) set.add(num);

        int result = 0, count = 0;
        while (head != null) {
            if (set.contains(head.val)) count++;
            else {
                if (count != 0) result++;
                count = 0;
            }

            head = head.next;
        }

        return count == 0 ? result : ++result;
    }

}
