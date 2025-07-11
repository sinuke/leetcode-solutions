package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PascalsTriangleIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void getRow(int rowIndex, List<Integer> expected) {
        var solution = new PascalsTriangleII();
        assertEquals(expected, solution.getRow(rowIndex));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, List.of(1,3,3,1)),
                Arguments.of(0, List.of(1)),
                Arguments.of(1, List.of(1,1))
        );
    }

}
