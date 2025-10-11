package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfTwoIntegersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getSum(int a, int b, int expected) {
        var solution = new SumOfTwoIntegers();
        assertEquals(expected, solution.getSum(a, b));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 3, 5)
        );
    }

}
