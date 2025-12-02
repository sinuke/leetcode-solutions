package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheArrayConcatenationValueTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findTheArrayConcVal(int[] nums, long expected) {
        var solution = new FindTheArrayConcatenationValue();
        assertEquals(expected, solution.findTheArrayConcVal(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {7,52,2,4}, 596L),
                Arguments.of(new int[] {5,14,13,8,12}, 673L)
        );
    }

}
