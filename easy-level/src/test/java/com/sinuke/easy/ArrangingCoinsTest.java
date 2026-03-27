package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrangingCoinsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void arrangeCoins(int n, int expected) {
        var solution = new ArrangingCoins();
        assertEquals(expected, solution.arrangeCoins(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(8, 3)
        );
    }

}
