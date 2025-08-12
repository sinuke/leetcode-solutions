package com.sinuke.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeKSortedListsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeKLists(MergeKSortedLists.ListNode[] lists, MergeKSortedLists.ListNode expected) {
        var solution = new MergeKSortedLists();
        assertArrayEquals(extractValues(expected), extractValues(solution.mergeKLists(lists)));
        assertArrayEquals(extractValues(expected), extractValues(solution.mergeKLists2(lists)));
        assertArrayEquals(extractValues(expected), extractValues(solution.mergeKLists3(lists)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new MergeKSortedLists.ListNode[] {createList(1,4,5), createList(1,3,4), createList(2,6)}, createList(1,1,2,3,4,4,5,6)),
                Arguments.of(new MergeKSortedLists.ListNode[] {}, createList()),
                Arguments.of(new MergeKSortedLists.ListNode[] {createList()}, createList()),
                Arguments.of(new MergeKSortedLists.ListNode[] {createList(-2,-1,-1,-1), createList()}, createList(-2,-1,-1,-1))
        );
    }

    private static MergeKSortedLists.ListNode createList(int... values) {
        if (values.length == 0) return null;

        var head = new MergeKSortedLists.ListNode(values[0]);
        var previous = head;
        for (int i = 1; i < values.length; i++) {
            var element = new MergeKSortedLists.ListNode(values[i]);
            previous.next = element;
            previous = element;
        }

        return head;
    }

    private static int[] extractValues(MergeKSortedLists.ListNode node) {
        if (node == null) return null;

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
