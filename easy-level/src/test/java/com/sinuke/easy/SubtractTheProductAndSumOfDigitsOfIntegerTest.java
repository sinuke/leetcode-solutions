package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubtractTheProductAndSumOfDigitsOfIntegerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void subtractProductAndSum(int n, int expected) {
        var subtractor = new SubtractTheProductAndSumOfDigitsOfInteger();
        assertEquals(expected, subtractor.subtractProductAndSum(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(234, 15),
                Arguments.of(4421, 21)
        );
    }

}
