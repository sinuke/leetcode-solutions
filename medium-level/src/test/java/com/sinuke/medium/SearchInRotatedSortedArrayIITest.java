package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInRotatedSortedArrayIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void search(int[] nums, int target, boolean expected) {
        var solution = new SearchInRotatedSortedArrayII();
        assertEquals(expected, solution.search(nums, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,5,6,0,0,1,2}, 0, true),
                Arguments.of(new int[] {2,5,6,0,0,1,2}, 3, false),
                Arguments.of(new int[] {1,0,0,0,0,0,0,0}, 1, true),
                Arguments.of(new int[] {0,0,0,0,0,0,0,1}, 1, true),
                Arguments.of(new int[] {1,0,0,0,0,0,0,0}, 2, false),
                Arguments.of(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2, true),
                Arguments.of(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 3, false)
        );
    }

}
