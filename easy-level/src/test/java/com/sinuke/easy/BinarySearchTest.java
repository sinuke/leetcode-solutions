package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @ParameterizedTest
    @MethodSource("testData")
    void search(int[] nums, int target, int expected) {
        var solution = new BinarySearch();
        assertEquals(expected, solution.search(nums, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {-1,0,3,5,9,12}, 9, 4),
                Arguments.of(new int[] {-1,0,3,5,9,12}, 2, -1)
        );
    }

}
