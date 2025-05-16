package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaterBottlesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numWaterBottles(int numBottles, int numExchange, int expected) {
        var solution = new WaterBottles();
        assertEquals(expected, solution.numWaterBottles(numBottles, numExchange));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(9, 3, 13),
                Arguments.of(15, 4, 19)
        );
    }

}
