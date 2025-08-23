package com.sinuke.easy;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.createList;
import static com.sinuke.common.data.ListNode.extractValues;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeTwoSortedListsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeTwoLists(ListNode l1, ListNode l2, ListNode expected) {
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

}
