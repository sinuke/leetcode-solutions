package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CanMakeArithmeticProgressionFromSequenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void canMakeArithmeticProgression(int[] arr, boolean expected) {
        var solution = new CanMakeArithmeticProgressionFromSequence();
        assertEquals(expected, solution.canMakeArithmeticProgression(arr));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,5,1}, true),
                Arguments.of(new int[] {1,2,4}, false)
        );
    }

}
