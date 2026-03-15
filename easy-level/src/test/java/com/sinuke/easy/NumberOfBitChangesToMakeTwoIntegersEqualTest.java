package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfBitChangesToMakeTwoIntegersEqualTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minChanges(int n, int k, int expected) {
        var solution = new NumberOfBitChangesToMakeTwoIntegersEqual();
        assertEquals(expected, solution.minChanges(n, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(13, 4, 2),
                Arguments.of(21, 21, 0),
                Arguments.of(14, 13, -1)
        );
    }

}
