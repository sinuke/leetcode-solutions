package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDigitFromNumberToMaximizeResultTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeDigit(String number, char digit, String expected) {
        var solution = new RemoveDigitFromNumberToMaximizeResult();
        assertEquals(expected, solution.removeDigit(number, digit));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("123", '3', "12"),
                Arguments.of("1231", '1', "231"),
                Arguments.of("551", '5', "51")
        );
    }

}
