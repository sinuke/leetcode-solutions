package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PascalsTriangleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void generate(int numRows, List<List<Integer>> expected) {
        var solution = new PascalsTriangle();
        assertEquals(expected, solution.generate(numRows));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1,4,6,4,1))),
                Arguments.of(1, List.of(List.of(1)))
        );
    }

}
