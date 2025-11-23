package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeDivisorsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isThree(int n, boolean expected) {
        var solution = new ThreeDivisors();
        assertEquals(expected, solution.isThree(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, false),
                Arguments.of(4, true)
        );
    }

}
