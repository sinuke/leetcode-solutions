package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindDegreeOfEachVertexTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findDegrees(int[][] matrix, int[] expected) {
        assertArrayEquals(expected, new FindDegreeOfEachVertex().findDegrees(matrix));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, new int[] {2, 2, 2}),
                Arguments.of(new int[][] {{0, 1, 0}, {1, 0, 0}, {0, 0, 0}}, new int[] {1, 1, 0}),
                Arguments.of(new int[][] {{0}}, new int[] {0})
        );
    }

}
