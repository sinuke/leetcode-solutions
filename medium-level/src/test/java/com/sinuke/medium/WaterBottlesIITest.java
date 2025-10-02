package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaterBottlesIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxBottlesDrunk(int numBottles, int numExchange, int expected) {
        var solution = new WaterBottlesII();
        assertEquals(expected, solution.maxBottlesDrunk(numBottles, numExchange));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(13, 6, 15),
                Arguments.of(10, 3, 13)
        );
    }

}
