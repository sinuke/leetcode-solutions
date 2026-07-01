package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RabbitsInForestTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numRabbits(int[] answers, int expected) {
        var solution = new RabbitsInForest();
        assertEquals(expected, solution.numRabbits(answers));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2}, 5),
                Arguments.of(new int[]{10, 10, 10}, 11)
        );
    }

}
