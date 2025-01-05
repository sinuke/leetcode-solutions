package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivisibleAndNonDivisibleSumsDifferenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void differenceOfSums(int n, int m, int expected) {
        var diff = new DivisibleAndNonDivisibleSumsDifference();
        assertEquals(expected, diff.differenceOfSums(n, m));
        assertEquals(expected, diff.differenceOfSums2(n, m));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(10, 3, 19),
                Arguments.of(5, 6, 15),
                Arguments.of(5, 1, -15)
        );
    }

}
