package com.sinuke.easy;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class RemoveDuplicatesFromSortedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void deleteDuplicates(ListNode input, ListNode expected) {
        var removeDuplicates = new RemoveDuplicatesFromSortedList();

        var result = removeDuplicates.deleteDuplicates(input);
        var expectedArray = toArray(expected);
        var resultArray = toArray(result);

        assertArrayEquals(expectedArray, resultArray);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of(buildList(1, 1, 2), buildList(1, 2)),
            Arguments.of(buildList(1, 1, 2, 3, 3), buildList(1, 2, 3))
        );
    }

}
