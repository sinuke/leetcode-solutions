package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInsertPositionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void searchInsert(int[] input, int target, int expected) {
        var searchPosition = new SearchInsertPosition();

        assertEquals(expected, searchPosition.searchInsert(input, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of(new int[] {1, 3, 5, 6}, 5, 2),
            Arguments.of(new int[] {1, 3, 5, 6}, 2, 1),
            Arguments.of(new int[] {1, 3, 5, 6}, 7, 4),
            Arguments.of(new int[] {1, 3, 5, 6}, 0, 0)
        );
    }

}
