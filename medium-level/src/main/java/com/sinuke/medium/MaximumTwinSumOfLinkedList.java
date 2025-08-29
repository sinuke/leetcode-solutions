package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumOfLinkedList {

    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>(100_001);
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int max = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            max = Math.max(max, list.get(i) + list.get(list.size() - i - 1));
        }
        return max;
    }

}
