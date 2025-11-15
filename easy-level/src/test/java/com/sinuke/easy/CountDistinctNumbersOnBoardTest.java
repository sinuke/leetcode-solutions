package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountDistinctNumbersOnBoardTest {

    @ParameterizedTest
    @MethodSource("testData")
    void distinctIntegers(int n, int expected) {
        var solution = new CountDistinctNumbersOnBoard();
        assertEquals(expected, solution.distinctIntegers(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 4),
                Arguments.of(1, 1),
                Arguments.of(3, 2)
        );
    }

}
