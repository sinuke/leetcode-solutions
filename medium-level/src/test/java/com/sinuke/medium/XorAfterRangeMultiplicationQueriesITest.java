package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XorAfterRangeMultiplicationQueriesITest {

    @ParameterizedTest
    @MethodSource("testData")
    void xorAfterQueries(int[] nums, int[][] queries, int expected) {
        assertEquals(expected, new XorAfterRangeMultiplicationQueriesI().xorAfterQueries(nums, queries));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 1, 1}, new int[][] {{0, 2, 1, 4}}, 4),
                Arguments.of(new int[] {2, 3, 1, 5, 4}, new int[][] {{1, 4, 2, 3}, {0, 2, 1, 2}}, 31)
        );
    }

}
