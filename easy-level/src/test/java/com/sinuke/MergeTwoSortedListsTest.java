package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeTwoSortedListsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeTwoLists(MergeTwoSortedLists.ListNode l1, MergeTwoSortedLists.ListNode l2, MergeTwoSortedLists.ListNode expected) {
        var mergeLists = new MergeTwoSortedLists();

        var result = mergeLists.mergeTwoLists(l1, l2);
        var resultArray = extractValues(result);
        var expectedArray = extractValues(expected);

        assertArrayEquals(expectedArray, resultArray);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(1, 2, 4), createList(1, 3, 4), createList(1, 1, 2, 3, 4, 4)),
                Arguments.of(createList(), createList(), createList()),
                Arguments.of(createList(), createList(0), createList(0)),
                Arguments.of(createList(1, 4, 5, 7), createList(3, 6, 10, 11), createList(1, 3, 4, 5, 6, 7, 10, 11))
        );
    }

    private static MergeTwoSortedLists.ListNode createList(int... values) {
        if (values.length == 0) return null;

        var head = new MergeTwoSortedLists.ListNode(values[0]);
        var previous = head;
        for (int i = 1; i < values.length; i++) {
            var element = new MergeTwoSortedLists.ListNode(values[i]);
            previous.next = element;
            previous = element;
        }

        return head;
    }

    private static int[] extractValues(MergeTwoSortedLists.ListNode node) {

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
