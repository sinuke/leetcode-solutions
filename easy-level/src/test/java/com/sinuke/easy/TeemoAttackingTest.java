package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeemoAttackingTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findPoisonedDuration(int[] timeSeries, int duration, int expected) {
        var solution = new TeemoAttacking();
        assertEquals(expected, solution.findPoisonedDuration(timeSeries, duration));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 4}, 2, 4),
                Arguments.of(new int[]{1, 2}, 2, 3)
        );
    }
    
}
