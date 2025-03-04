package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfNumberIsSumOfPowersOfThreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkPowersOfThree(int n, boolean expected) {
        var solution = new CheckIfNumberIsSumOfPowersOfThree();
        assertEquals(expected, solution.checkPowersOfThree(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(12, true),
                Arguments.of(91, true),
                Arguments.of(21, false)
        );
    }

}
