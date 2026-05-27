package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LinkedListCycleIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void detectCycle(int[] values, int pos, Integer expectedVal) {
        ListNode head = buildCyclicList(values, pos);
        ListNode result = new LinkedListCycleII().detectCycle(head);
        if (expectedVal == null) {
            assertNull(result);
        } else {
            assertEquals(expectedVal, result.val);
        }
    }

    private static ListNode buildCyclicList(int[] values, int pos) {
        if (values.length == 0) return null;
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
        }
        for (int i = 0; i < values.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        if (pos >= 0) {
            nodes[values.length - 1].next = nodes[pos];
        }
        return nodes[0];
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 0, -4}, 1, 2),
                Arguments.of(new int[]{1, 2}, 0, 1),
                Arguments.of(new int[]{1}, -1, null)
        );
    }

}
