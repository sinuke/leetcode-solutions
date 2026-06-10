package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumEnemyFortsThatCanBeCapturedTest {

    @ParameterizedTest
    @MethodSource("testData")
    void captureForts(int[] forts, int expected) {
        assertEquals(expected, new MaximumEnemyFortsThatCanBeCaptured().captureForts(forts));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 0, 0, -1, 0, 0, 0, 0, 1}, 4),
                Arguments.of(new int[] {0, 0, 1, -1}, 0)
        );
    }

}
