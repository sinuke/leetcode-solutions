package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountOperationsToObtainZeroTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countOperations(int num1, int num2, int expected) {
        var solution = new CountOperationsToObtainZero();
        assertEquals(expected, solution.countOperations(num1, num2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, 3, 3),
                Arguments.of(10, 10, 1)
        );
    }

}
