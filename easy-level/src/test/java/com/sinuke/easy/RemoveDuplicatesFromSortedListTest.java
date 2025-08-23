package com.sinuke.easy;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.createList;
import static com.sinuke.common.data.ListNode.extractValues;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class RemoveDuplicatesFromSortedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void deleteDuplicates(ListNode input, ListNode expected) {
        var removeDuplicates = new RemoveDuplicatesFromSortedList();

        var result = removeDuplicates.deleteDuplicates(input);
        var expectedArray = extractValues(expected);
        var resultArray = extractValues(result);

        assertArrayEquals(expectedArray, resultArray);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of(createList(1, 1, 2), createList(1, 2)),
            Arguments.of(createList(1, 1, 2, 3, 3), createList(1, 2, 3))
        );
    }

}
