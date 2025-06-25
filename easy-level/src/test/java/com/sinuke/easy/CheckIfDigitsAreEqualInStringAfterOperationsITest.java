package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfDigitsAreEqualInStringAfterOperationsITest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasSameDigits(String s, boolean expected) {
        var solution = new CheckIfDigitsAreEqualInStringAfterOperationsI();
        assertEquals(expected, solution.hasSameDigits(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("3902", true),
                Arguments.of("34789", false)
        );
    }

}
