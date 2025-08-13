package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void search(int[] nums, int target, int expected) {
        var solution = new SearchInRotatedSortedArray();
        assertEquals(expected, solution.search(nums, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,5,6,7,0,1,2}, 0, 4),
                Arguments.of(new int[] {4,5,6,7,0,1,2}, 3, -1),
                Arguments.of(new int[] {1}, 0, -1),
                Arguments.of(new int[] {8,9,0,1,2,3,4,5,6,7}, 1, 3),
                Arguments.of(new int[] {9,0,1,2,3,4,5,6,7,8}, 8, 9),
                Arguments.of(new int[] {8,9,0,1,2,3,4,5,6,7}, 8, 0)
        );
    }

}
