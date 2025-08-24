package com.sinuke.hard;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeKSortedListsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeKLists(ListNode[] lists, ListNode expected) {
        var solution = new MergeKSortedLists();
        assertArrayEquals(toArray(expected), toArray(solution.mergeKLists(lists.clone())));
        assertArrayEquals(toArray(expected), toArray(solution.mergeKLists2(lists.clone())));
        assertArrayEquals(toArray(expected), toArray(solution.mergeKLists3(lists.clone())));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new ListNode[] {buildList(1,4,5), buildList(1,3,4), buildList(2,6)}, buildList(1,1,2,3,4,4,5,6)),
                Arguments.of(new ListNode[] {}, buildList()),
                Arguments.of(new ListNode[] {buildList()}, buildList()),
                Arguments.of(new ListNode[] {buildList(-2,-1,-1,-1), buildList()}, buildList(-2,-1,-1,-1))
        );
    }

}
