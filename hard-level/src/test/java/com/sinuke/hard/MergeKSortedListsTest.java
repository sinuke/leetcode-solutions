package com.sinuke.hard;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.createList;
import static com.sinuke.common.data.ListNode.extractValues;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeKSortedListsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeKLists(ListNode[] lists, ListNode expected) {
        var solution = new MergeKSortedLists();
        assertArrayEquals(extractValues(expected), extractValues(solution.mergeKLists(lists.clone())));
        assertArrayEquals(extractValues(expected), extractValues(solution.mergeKLists2(lists.clone())));
        assertArrayEquals(extractValues(expected), extractValues(solution.mergeKLists3(lists.clone())));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new ListNode[] {createList(1,4,5), createList(1,3,4), createList(2,6)}, createList(1,1,2,3,4,4,5,6)),
                Arguments.of(new ListNode[] {}, createList()),
                Arguments.of(new ListNode[] {createList()}, createList()),
                Arguments.of(new ListNode[] {createList(-2,-1,-1,-1), createList()}, createList(-2,-1,-1,-1))
        );
    }

}
