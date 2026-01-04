package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FourDivisorsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumFourDivisors(int[] nums, int expected) {
        var solution = new FourDivisors();
        assertEquals(expected, solution.sumFourDivisors(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {21,4,7}, 32),
                Arguments.of(new int[] {21,21}, 64),
                Arguments.of(new int[] {1,2,3,4,5}, 0)
        );
    }

}
