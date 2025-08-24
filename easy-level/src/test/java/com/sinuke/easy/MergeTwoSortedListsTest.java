package com.sinuke.easy;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeTwoSortedListsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeTwoLists(ListNode l1, ListNode l2, ListNode expected) {
        var mergeLists = new MergeTwoSortedLists();

        var result = mergeLists.mergeTwoLists(l1, l2);
        var resultArray = toArray(result);
        var expectedArray = toArray(expected);

        assertArrayEquals(expectedArray, resultArray);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(1, 2, 4), buildList(1, 3, 4), buildList(1, 1, 2, 3, 4, 4)),
                Arguments.of(buildList(), buildList(), buildList()),
                Arguments.of(buildList(), buildList(0), buildList(0)),
                Arguments.of(buildList(1, 4, 5, 7), buildList(3, 6, 10, 11), buildList(1, 3, 4, 5, 6, 7, 10, 11))
        );
    }

}
